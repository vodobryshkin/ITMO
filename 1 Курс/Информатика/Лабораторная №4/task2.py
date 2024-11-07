"""
Название: Лабораторная работа №4
Автор: (c) Добрышкин Владимир Александрович
Дата создания: 06.11.2024
Описание: Лабораторная работа по дисциплине "Информатика" по работе с языками разметки
Версия: 1.0
"""

import json
import yaml


def json_to_yaml2(file_name):
    with open(file_name, 'r', encoding='utf-8') as json_file:
        data = json.load(json_file)

    with open(f"output/{file_name.split('.json')[0].split('/')[1] + '2.yaml'}", 'w', encoding='utf-8') as yaml_file:
        yaml.dump(data, yaml_file, default_flow_style=False, allow_unicode=True)


def main():
    # print(clear_spaces(open("data/second_example.json", mode='r', encoding='utf-8').read() ))
    json_to_yaml2("data/self_schedule.json")


if __name__ == '__main__':
    main()


# Чтение JSON файла


# Запись данных в YAML файл

