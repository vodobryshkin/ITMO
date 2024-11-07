import re
from general_tools.program_tools import clean_spaces
from functools import lru_cache


# <file> ::= <object>
# <object> ::= <mapping>
# <mapping> ::= <pair> | <pair>, <mapping>
# <pair> ::= <key>: <value>
# <key> ::= <string>
# <value> ::= <scalar> | <object> | <list>
# <scalar> ::= <int> | <float> | <bool> | <string> | <null>
# <list> ::= <value> | [<value>, <list>] | []
# <int> ::= r"-?\d+"
# <float> ::= r"-?\d+\.\d+"
# <string> ::= r"\"[^\"]+\""
# <bool> ::= <true> | <false>
# <true> ::= r"^true"
# <false> ::= r"^false"
# <null> ::= r"^null"


JSON_PATTERNS = {
    "<object>": r"{.*}",
    "<list>": r"\[.*\]",
    "<float>": r"-?\d+\.\d+",
    "<int>": r"-?\d+",
    "<string>": r"\"[^\"]+\"",
    "<true>": r"^true",
    "<false>": r"^false",
    "<null>": r"^null"
}


# Класс для парсинга JSON файла
class JSONParser:
    def parse(self, json_file):
        clean_json = clean_spaces(json_file)
        return self._parse_object(clean_json[:-1])

    @lru_cache
    def _parse_object(self, json_file):
        assert re.fullmatch(JSON_PATTERNS["<object>"], json_file), "Incorrect Object"
        # Исправление костыля
        if json_file[-1] == ',':
            return self._parse_mapping(json_file[1:-2])
        else:
            return self._parse_mapping(json_file[1:-1])

    @lru_cache
    def _parse_mapping(self, mapping_line):
        result_map = {}
        sub_s = ""

        for i in range(len(mapping_line)):
            # Поиск запятой для перехода к нетерминальному правилу вида <mapping> ::= <pair>, <mapping>
            if mapping_line[i] == "," \
                    and sub_s.count("\"") % 2 == 0\
                    and sub_s.count("{") == sub_s.count("}") \
                    and sub_s.count("[") == sub_s.count("]"):
                key, val = self._parse_pair(sub_s.strip())
                result_map[key] = val
                sub_s = ""
            else:
                sub_s += mapping_line[i]

            # Поиск запятой для перехода к нетерминальному правилу вида <mapping> ::= <pair>
            if i == len(mapping_line) - 1:
                key, val = self._parse_pair(sub_s.strip())
                result_map[key] = val
                sub_s = ""

        return result_map

    @lru_cache
    def _parse_pair(self, pair_line):
        # Поиск двоеточия для перехода к нетерминальному правилу вида <pair> ::= <key>: <value>
        key, value = "", pair_line
        for i in range(len(pair_line)):
            if pair_line[i] == ':' \
                    and key.count("{") == key.count("}") \
                    and key.count("[") == key.count("]"):
                key = key.strip()
                if value[0:2] == ': ':
                    value = value[1:].strip()
                break
            else:
                key += pair_line[i]
            value = value[1:].strip()
        # Разделение на <key> и <value> для поэтапной обработки
        return self._parse_key(key), self._parse_value(value)

    @lru_cache
    def _parse_key(self, key_line):
        # Переход к нетерминальному правилу вида <key> ::= <string>
        return self._parse_string(key_line)

    @lru_cache
    def _parse_value(self, value_line):
        # Переход к нетерминальному правилу вида <value> ::= <object>
        if re.fullmatch(JSON_PATTERNS["<object>"], value_line):
            return self._parse_object(value_line)
        # Переход к нетерминальному правилу вида <value> ::= <list>
        elif re.fullmatch(JSON_PATTERNS["<list>"], value_line):
            return self._parse_list(value_line)
        # Переход к нетерминальному правилу вида <value> ::= <scalar>
        else:
            return self._parse_scalar(value_line)

    @lru_cache
    def _parse_list(self, list_line):
        # Переход к нетерминальному правилу вида <list> ::= []
        if len(list_line.strip()) == 0:
            return []
        # Переход к нетерминальному правилу вида <list> ::= [<value>, <list>]
        else:
            result_list = []
            sub_s = ""
            list_line = list_line[:-1] + ','

            for i in range(1, len(list_line)):
                # Переход к нетерминальному правилу вида <list> ::= <value>
                if list_line[i] == "," \
                        and sub_s.count("{") == sub_s.count("}") \
                        and sub_s.count("[") == sub_s.count("]"):
                    result_list.append(self._parse_value(sub_s.strip()))
                    sub_s = ""
                elif i == len(list_line):
                    result_list.append(self._parse_value(sub_s.strip()))
                else:
                    sub_s += list_line[i]

        return result_list

    @lru_cache
    def _parse_scalar(self, scalar_line):
        # Переход к нетерминальному правилу вида <scalar> ::= <int>
        if re.fullmatch(JSON_PATTERNS["<int>"], scalar_line):
            return self._parse_int(scalar_line)
        # Переход к нетерминальному правилу вида <scalar> ::= <float>
        elif re.fullmatch(JSON_PATTERNS["<float>"], scalar_line):
            return self._parse_float(scalar_line)
        # Переход к нетерминальному правилу вида <scalar> ::= <string>
        elif re.fullmatch(JSON_PATTERNS["<string>"], scalar_line):
            return self._parse_string(scalar_line)
        # Переход к нетерминальному правилу вида <scalar> ::= <string>
        elif re.fullmatch(JSON_PATTERNS["<null>"], scalar_line):
            return self._parse_null()
        # Переход к нетерминальному правилу вида <scalar> ::= <bool>
        else:
            return self._parse_bool(scalar_line)

    @lru_cache
    def _parse_bool(self, bool_line):
        # Переход к нетерминальному правилу вида <bool> ::= <true>
        if re.fullmatch(JSON_PATTERNS["<true>"], bool_line):
            return self._parse_true()
        # Переход к нетерминальному правилу вида <bool> ::= <false>
        elif re.fullmatch(JSON_PATTERNS["<false>"], bool_line):
            return self._parse_false()

    @staticmethod
    def _parse_string(string_line):
        # Проверка на то, что это строка в ключе
        assert re.fullmatch(JSON_PATTERNS["<string>"], string_line), f"Key is not a string{string_line}"
        return string_line[1:-1]

    @staticmethod
    def _parse_int(int_line):
        return int(int_line)

    @staticmethod
    def _parse_float(float_line):
        return float(float_line)

    @staticmethod
    def _parse_true():
        return True

    @staticmethod
    def _parse_false():
        return False

    @staticmethod
    def _parse_null():
        return None
