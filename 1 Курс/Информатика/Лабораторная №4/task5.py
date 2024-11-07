"""
Название: Лабораторная работа №4
Автор: (c) Добрышкин Владимир Александрович
Дата создания: 06.11.2024
Описание: Лабораторная работа по дисциплине "Информатика" по работе с языками разметки
Версия: 1.0
"""

import time

from task1 import json_to_yaml1
from task2 import json_to_yaml2
from task3 import json_to_yaml3
from task4 import json_to_yaml4


file_name = "data/self_schedule.json"


def get_time(func, file_name):
    start_time = time.time()
    for _ in range(100):
        func(file_name)
    end_time = time.time()
    return end_time - start_time


def main():
    time1 = get_time(json_to_yaml1, file_name)
    time2 = get_time(json_to_yaml2, file_name)
    time3 = get_time(json_to_yaml3, file_name)
    time4 = get_time(json_to_yaml4, file_name)

    print(f"Время выполнения функции из обязательного задания: {time1:.4f} секунд")
    print(f"Время выполнения функции из дополнительного задания №1: {time2:.4f} секунд")
    print(f"Время выполнения функции из дополнительного задания №2: {time3:.4f} секунд")
    print(f"Время выполнения функции из дополнительного задания №3: {time4:.4f} секунд")


if __name__ == '__main__':
    main()