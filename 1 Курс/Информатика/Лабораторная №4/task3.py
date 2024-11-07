"""
Название: Лабораторная работа №4
Автор: (c) Добрышкин Владимир Александрович
Дата создания: 06.11.2024
Описание: Лабораторная работа по дисциплине "Информатика" по работе с языками разметки
Версия: 1.0
"""

import re


def parser_json_to_yaml(data):
    # Замена запятых и кавычек на пустоту
    data = re.sub(r"\"", "", data)
    data = re.sub(r",", "", data)

    # Замена "особых" строк
    digit_strings = set(re.findall(r"\d+:\d+", data))
    for digit_string in digit_strings:
        data = re.sub(digit_string, f"'{digit_string}'", data)

    # Замена массивов и структур
    data = re.sub(r"\s+[\[\{]", "", data)
    array_elements = set(re.findall(r"\s{14}\w+\s", data))
    for array_element in array_elements:
        data = re.sub(array_element, '-' + array_element[3:], data)

    # Избавление от избыточности в начале строк
    lines = set(re.findall("\s{6}\w{1}", data))
    for line in lines:
        data = re.sub(line, f'{line[6]}', data)

    # Избавление от избыточности в начале строк
    lines = set(re.findall("\s{4}\w{1}", data))
    for line in lines:
        data = re.sub(line, f'{line[4]}', data)

    # Повторная обработка массивов
    lines = set(re.findall("^\s*lesson:", data, re.M))
    for line in lines:
        p_data = list(line)
        p_data[4] = '-'
        data = re.sub(line, "".join(p_data), data)

    # Повторная обработка массивов
    lines = set(re.findall(r"^\s{10}[^\s\-]", data, re.M))
    for line in lines:
        data = re.sub(line, f'{8 * " "}{line[-1]}', data)

    # Избавление от закрывающихся скобок
    empty_lines = set(re.findall("^\s*[{}\[\]]*\n", data, re.M))
    for line in empty_lines:
        data = re.sub(line, '\n', data)
    data = re.sub(r'^[\n]*$', '', data, flags=re.MULTILINE)

    new_data = []

    for line in data.split('\n'):
        if len(set(line)) > 1:
            new_data.append(line)

    return "\n".join(new_data)


def json_to_yaml3(file_name):
    f = open(file_name, mode='r', encoding='utf-8').read()
    text = parser_json_to_yaml(f)
    with open(f"output/{file_name.split('.json')[0].split('/')[1] + '3.yaml'}", mode='w', encoding='utf-8') as new_file:
        new_file.write(text)


def main():
    json_to_yaml3("data/self_schedule.json")


if __name__ == '__main__':
    main()