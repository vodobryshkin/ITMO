"""
Название программы: Лабораторная работа №3
Автор: (c) Добрышкин Владимир Александрович
Дата создания: 10.10.2024
Описание: Лабораторная работа по дисциплине "Информатика" по работе с регулярными выражениями (regular expressions)
Версия: 1.0
"""


from tools.compare_results import compare_results  # функция для того, чтобы сверить собственные ответы и ответы,
# полученные от функций

import re

# 1 тест - один повторяющийся корень прилагательного в разных падежах
# 2 тест - два повторяющихся корня прилагательного в разных падежах
# 3 тест - один повторяющийся корень у прилагательных и других частей речи
# 4 тест - нет повторяющихся корней
# 5 тест - повторяющийеся корни у частей речи, отличных от прилагательного


# Функция для решения второго дополнительного задания (прилагательные)
def additional_solution_5_mark(number, text):
    # Изначально результат равен начальному тексту, так как возможно ничего не поменяется.
    result = text

    # Получение списка всех прилагательных с помощью регулярного выражения. Первая группа - буквы от а(А) до я(Я),
    # вторая группа символов - суффиксы прилагательных (почти у каждого прилагательного есть суффикс), третья группа
    # символов - окончания прилагательных. На выходе получается список кортежей вида (корень, суффикс, окончание).
    adjectives = re.findall(r'\b([а-яА-Яё]+)'
                            r'(н|нн|ов|ев|иск|ичн|ист|чат|лив|оват|цк|ск|к|реньк|ем|ющ|ящ|а|я|иньк|р|ин)'
                            r'(ой|ий|ый|ое|ее|ая|яя|ие|ые|ого|его|ей|их|ых|ому|ему|им|ым|ую|юю|ими|ыми|ом|ем|ся)\b',
                            text)
    # print(adjectives)

    # Словарь, в который будут записываться список всех окончаний для данного корня и суффикса.
    dict_of_words = {}

    # Обработка всех слов.
    for word in adjectives:
        # print(word)

        # Если вызовется ошибка KeyError, то такого ключа нет в словаре и нужно его создать. Иначе просто добавить
        # элемент в список под данным ключом.
        try:
            dict_of_words[word[0].lower()].append(word[1] + word[2])
        except KeyError:
            dict_of_words[word[0].lower()] = [word[1] + word[2]]
    # print(dict_of_words)

    # Обработка всех падежных окончаний, характерных для данных корня и суффикса
    for key in dict_of_words.keys():
        # Если для данных корня и суффикса несколько падежных окончаний, а так же их количество больше или равно номеру
        # замены, то выполняется замена
        if len(dict_of_words[key]) > 1 and len(dict_of_words[key]) >= number:
            # Обработка слов с первой буквой в нижнем регистре
            lower_pattern = f'{key}({"|".join(dict_of_words[key])})'
            lower_repr = f'{key}{dict_of_words[key][number - 1]}'
            # print(lower_pattern, lower_repr)

            # Обработка слов с первой буквой в верхнем регистре
            upper_pattern = f'({key.capitalize()})({"|".join(dict_of_words[key])})'
            upper_repr = f'{key.capitalize()}{dict_of_words[key][number - 1]}'
            # print(upper_pattern, upper_repr)

            # Замена всех слов с соответствующими корнем и суффиксом на необходимую падежную форму
            result = re.sub(lower_pattern, lower_repr, result, re.MULTILINE)
            result = re.sub(upper_pattern, upper_repr, result, re.MULTILINE)

    return result


def main():
    # Получение ответа для каждого из тестов
    results = []
    for i in range(5):
        file = open(f"tests\\additional task 5 mark\\test{i + 1}.txt", mode='r', encoding='utf-8')

        num = int(file.readline().split()[1])
        file.readline()
        text = file.read()

        test = additional_solution_5_mark(num, text)
        results.append(str(test))

    for i in range(5):
        print(f'Ответ программы на {i + 1} тест - {results[i]}')

    # Сравнение ответов самостоятельного и программного решений
    print(compare_results(f"config\\additional task 5 mark.txt", results, "add2"))


if __name__ == '__main__':
    main()
