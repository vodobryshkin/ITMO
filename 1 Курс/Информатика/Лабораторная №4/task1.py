"""
Название: Лабораторная работа №4
Автор: (c) Добрышкин Владимир Александрович
Дата создания: 06.11.2024
Описание: Лабораторная работа по дисциплине "Информатика" по работе с языками разметки
Версия: 1.0
"""

from general_tools.program_tools import clean_spaces
from json_tools.json_tools import define_type, yaml_type

BACK_SYMBOLS = {
    '[': ']',
    '{': '}',
    '"': '"'
}


# Функция для выполнения обязательного задания (ручной парсинг из json в yaml)
def parser_json_to_yaml(data, tab_level=''):
    # data = open(file_name, mode='r', encoding='utf-8').read()  # Открытие файла
    clear_data = clean_spaces(data)  # Очищение текста файла от избыточных символов табуляций, переноса строк и пробелов
    # Флаг и переменная, отвечающие за распознание и поиск контейнеров в строке
    is_reading_subsequence = False
    subsequence_symbol = ''
    # Для правильного обнаружения стркуктуры необходимо использовать упрощённый алгоритм правильной скобчатой
    # последовательности, для чего нкжен счётчик
    correct_bracket_sequence_counter = 0

    # Строка для обработки подпоследовательности
    sub_str = ""

    # Итоговая строка
    result_string = ""

    # Флаг, показывающий часть, которую считывает парсер (ключ или значение)
    # key_or_value_str = "key"
    quote_flag = False

    for i in range(len(clear_data)):
        if not is_reading_subsequence:
            if clear_data[i] == "," and not quote_flag:
                if sub_str != "":
                    key, val = sub_str[:sub_str.find(':')].strip(), sub_str[sub_str.find(':') + 1:].strip()
                    result_string += f'\n{tab_level}{yaml_type(key)}: {yaml_type(val)}'
                sub_str = ""

        # Если символ строки это один из видов открывающихся скобок, то необходимо ловить правильную скобчатую
        # последовательность.
        if clear_data[i] in ['{', '['] and not is_reading_subsequence:
            sub_str += clear_data[i]
            is_reading_subsequence = True
            subsequence_symbol = clear_data[i]
            correct_bracket_sequence_counter += 1
            continue

        # Если символ строки не является открыающиейся скобкой
        elif clear_data[i] not in ['{', '['] and not is_reading_subsequence:
            sub_str += clear_data[i]
            if clear_data[i] == '"' and quote_flag:
                quote_flag = False
            elif clear_data[i] == '"' and not quote_flag:
                quote_flag = True

            if clear_data[i] == "," and not quote_flag:
                sub_str = ""

        # Если в данных момент считыается подпоследовательность между двух скобок
        if is_reading_subsequence:
            sub_str += clear_data[i]

            if clear_data[i] == BACK_SYMBOLS[subsequence_symbol]:
                correct_bracket_sequence_counter -= 1
            elif clear_data[i] == subsequence_symbol:
                correct_bracket_sequence_counter += 1

            # Счётчик будет равен нулю, когда первая скобка закрылась
            if correct_bracket_sequence_counter == 0:
                key, val = sub_str[:sub_str.find(':')].strip(), sub_str[sub_str.find(':') + 1:].strip()

                if define_type(val) == "array":
                    if "{" not in val:
                        result_string += f'\n{tab_level}{yaml_type(key)}:\n{yaml_type(val, array_tab=tab_level + "  ", self_tab=tab_level + "  ")}'
                    else:
                        result_string += f'\n{tab_level}{yaml_type(key)}:'
                        struct = ''
                        struct_f = False
                        struct_c = 0
                        for j in range(len(val)):
                            if val[j] == '{':
                                struct_c += 1
                                struct_f = True
                            if val[j] == '}':
                                struct_c -= 1

                            if struct_c == 0 and struct_f:
                                struct += ','
                                sub_str = list(f'{parser_json_to_yaml(struct[1:].strip(), tab_level + "    ")}')
                                for k in range(len(sub_str)):
                                    if sub_str[k] not in ' \n':
                                        sub_str[k - 2] = '-'
                                        break
                                result_string += "".join(list(sub_str))
                                struct_f = False
                                struct = ""
                            elif struct_f:
                                struct += val[j]
                else:
                    result_string += f'\n{tab_level}{yaml_type(key)}:{parser_json_to_yaml(val[1:len(val) - 1], tab_level + "  ")}'

                sub_str = ""
                is_reading_subsequence = False

    return result_string


def json_to_yaml1(file_name):
    f = open(file_name, mode='r', encoding='utf-8').read()
    text = parser_json_to_yaml(f[1:len(f) - 1])[1:]
    with open(f"output/{file_name.split('.json')[0].split('/')[1] + '1.yaml'}", mode='w', encoding='utf-8') as new_file:
        new_file.write(text)


def main():
    # print(clear_spaces(open("data/second_example.json", mode='r', encoding='utf-8').read() ))
    json_to_yaml1("data/self_schedule.json")


if __name__ == '__main__':
    main()
