# Функция, которая опрделяет тип данных строки из json файла
def define_type(s):
    if s[0] == "{" and s[-1] == "}":  # Фигурные скобки указывают на то, что в структуру вложена структура
        return "structure"
    elif s[0] == "[" and s[-1] == "]":  # Квадратные скобки указывают на то, что в структуру вложен массив
        return "array"
    elif s[0] == s[-1] == '"':  # Кавычки указывают на то, что в структуру вложена строка
        if ':' in s:  # В данном случае нужно будет окружить строку одинарными кавычками
            return "digit-string"
        return "string"
    return "digit"


# Функция, которая приводит тип данных строки из json в yaml
def yaml_type(s, array_tab="  ", self_tab=""):
    object_type = define_type(s)
    if object_type == "string":
        return s[1:len(s) - 1]
    if object_type == "digit":
        return s
    if object_type == "digit-string":
        return f"'{s[1:len(s) - 1]}'"
    if object_type == "array":
        res = ""
        sub_str = ""
        br_su = False
        br_sch = 0
        s = s[1:len(s) - 1] + ','
        first_arr = True
        for i in range(len(s)):
            if s[i] == '[':
                br_sch += 1
                br_su = True
            if s[i] == ']':
                br_sch -= 1
            if br_sch == 0:
                br_su = False

            if s[i] == "," and not br_su:
                if first_arr and array_tab != "  ":
                    res += self_tab + '- ' + yaml_type(sub_str.strip(), array_tab + '  ') + '\n'
                    first_arr = False
                else:
                    res += array_tab + '- ' + yaml_type(sub_str.strip(), array_tab + '  ') + '\n'
                sub_str = ""
            else:
                sub_str += s[i]

        return res[:-1]
    return ""
