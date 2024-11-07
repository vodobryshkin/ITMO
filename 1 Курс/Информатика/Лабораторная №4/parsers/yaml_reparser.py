# <file> ::= <dict>
# <dict> ::= <mapping>
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


class YAMLReParser:
    def reparse(self, original_dict):
        return self._reparse_dict(original_dict)

    def _reparse_dict(self, dict_line, tab=''):
        # Проверка на соответствие нетерминальному выражению <file> ::= <dict>
        assert type(dict_line) == dict, "Invalid type: dictionary must be given"
        return self._reparse_mapping(dict_line, tab)

    def _reparse_mapping(self, mapping_line, tab=''):
        yaml_string = "\n"

        for key in mapping_line.keys():
            value = mapping_line[key]

            yaml_string += self._reparse_pair(key, value, tab)

        if tab == '':
            yaml_string = yaml_string[1:-1]
        return yaml_string

    def _reparse_pair(self, key, value, tab=''):
        return f"{tab}{self._reparse_key(key, tab)}: {self._reparse_value(value, tab)}"

    def _reparse_key(self, key_line, tab=''):
        assert type(key_line) != str or type(key_line) != int or type(key_line) != float or type(key_line) != bool \
               or type(key_line) is not None, "Invalid key type: key must be scalar value"
        return self._reparse_scalar(key_line, tab)

    def _reparse_value(self, value_line, tab=''):
        if type(value_line) == list:
            return self._reparse_list(value_line, tab + '  ')
        if type(value_line) == dict:
            return self._reparse_dict(value_line, tab + '  ')

        return self._reparse_scalar(value_line) + '\n'

    def _reparse_list(self, list_line, tab):
        list_str = "\n"
        for elem in list_line:
            value = self._reparse_value(elem, tab)
            if value[0] == '\n':
                value = value.lstrip('\n').lstrip()
            list_str += f'{tab}- {value}'
        return list_str

    def _reparse_scalar(self, scalar_line, tab=''):
        if type(scalar_line) == int:
            return self._reparse_int(scalar_line)
        if type(scalar_line) == float:
            return self._reparse_float(scalar_line)
        if type(scalar_line) == str:
            return self._reparse_string(scalar_line)
        if type(scalar_line) == bool:
            return self._reparse_bool(scalar_line)

        return self._reparse_null()

    @staticmethod
    def _reparse_string(string_line):
        if ':' in string_line:
            string_line = f"'{string_line}'"
        return string_line

    @staticmethod
    def _reparse_bool(bool_line):
        if bool_line:
            return 'true'
        return 'false'

    @staticmethod
    def _reparse_int(int_line):
        return str(int_line)

    @staticmethod
    def _reparse_float(float_line):
        return str(float_line)

    @staticmethod
    def _reparse_null():
        return 'null'
