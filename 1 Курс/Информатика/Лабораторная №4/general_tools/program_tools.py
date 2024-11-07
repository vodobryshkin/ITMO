# Функция для сокращения избыточности исходного json файла
def clean_spaces(s):
    res = ''
    f = True

    for i in range(len(s)):
        # Если встречается n подряд табуляций, пробелов или символов новой строки, то меняем всю последовательность на
        # один пробел
        if (s[i] == ' ' or s[i] == '\t' or s[i] == '\n') and f:
            res += ' '
            f = False
        elif s[i] != ' ' and s[i] != '\t' and s[i] != '\n':
            res += s[i]
            f = True

    # Очистка последовательностей от пробелов в начале
    return res[:].strip() + ','
