"""
Название: Лабораторная работа №4
Автор: (c) Добрышкин Владимир Александрович
Дата создания: 06.11.2024
Описание: Лабораторная работа по дисциплине "Информатика" по работе с языками разметки
Версия: 1.0
"""

from parsers.json_parser import JSONParser
from parsers.yaml_reparser import YAMLReParser


def parser_json_to_yaml(data):
    return YAMLReParser().reparse(JSONParser().parse(data))


def json_to_yaml4(file_name):
    f = open(file_name, mode='r', encoding='utf-8').read()
    text = parser_json_to_yaml(f)
    with open(f"output/{file_name.split('.json')[0].split('/')[1] + '4.yaml'}", mode='w', encoding='utf-8') as new_file:
        new_file.write(text)


def main():
    json_to_yaml4("data/self_schedule.json")


if __name__ == '__main__':
    main()
