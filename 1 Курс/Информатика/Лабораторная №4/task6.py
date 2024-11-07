"""
Название: Лабораторная работа №4
Автор: (c) Добрышкин Владимир Александрович
Дата создания: 07.11.2024
Описание: Лабораторная работа по дисциплине "Информатика" по работе с языками разметки
Версия: 1.0
"""

import re
from parsers.json_parser import JSONParser
from parsers.toml_reparser import TOMLReParser


def parser_json_to_toml(data):
    return TOMLReParser().reparse(JSONParser().parse(data))


def json_to_toml(file_name):
    f = open(file_name, mode='r', encoding='utf-8').read()
    text = parser_json_to_toml(f)
    text = re.sub(r"\[schedule]", "", text)
    text_arr = re.findall(r"\dday\s=\s\dday", text)
    for e in text_arr:
        text = re.sub(e, '', text)
    text_arr = set(re.findall(r"\dday", text, re.M))
    for e in text_arr:
        text = text.replace(e, f'schedule.{e}')
    text_arr = set(re.findall(r"^\[schedule.\dday]", text, re.M))
    for e in text_arr:
        text = text.replace(e, f'[{e}]')
    text_arr = set(re.findall(r"^\n\n\n", text, re.M))
    for e in text_arr:
        text = text.replace(e, f'\n')
    with open(f"output/{file_name.split('.json')[0].split('/')[1] + '.toml'}", mode='w', encoding='utf-8') as new_file:
        new_file.write(text)


def main():
    json_to_toml("data/self_schedule.json")


if __name__ == '__main__':
    main()
