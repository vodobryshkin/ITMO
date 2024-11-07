# <file> ::= <struct>
# <struct> ::= <mapping>
# <mapping> ::= <pair> | <pair>, <mapping>| <struct_name>\\n<struct> <mapping>
# <struct_name> ::= [<string>] | [<string>.<struct_name>]
# <pair> ::= <key> = <value>
# <key> ::= <key_string>
# <value> ::= <scalar> | <list>
# <list> ::= <value> | [ <value>, <list> ] | [ ]
# <scalar> ::= <int> | <float> | <string> | <bool> | <null>
# <int> ::= r"-?\d+"
# <float> ::= r"-?\d+\.\d+"
# <string> ::= "r"\"[^\"]+\"""
# <key_string> ::= r"\"[^\"]+\""
# <bool> ::= <true> | <false>
# <null> ::= ""

class TOMLReParser:
    def reparse(self, original_struct):
        return self._reparse_struct(original_struct)

    def _reparse_struct(self, struct_line, tab='', name='', key=''):
        assert type(struct_line) == dict, "Invalid type: dictionary must be given"
        return self._reparse_mapping(struct_line, tab, name)

    def _reparse_mapping(self, mapping_line, tab='', name=''):
        toml_str = name
        new_tab = ''

        if '.' in name:
            new_tab += '  '
        # \n{new_tab}[{name}]
        if name != '':
            toml_str = f'\n{new_tab}[{name}]\n'
        # Все пары ключ-значение, где значение - словарь
        dicts = {}

        for key in mapping_line.keys():
            value = mapping_line[key]

            if type(value) != dict:
                toml_str += f'{new_tab}{self._reparse_pair(key, value)}\n'
            else:
                dicts[key] = value
        for key in dicts.keys():
            value = dicts[key]
            new_name = f'{name}.{key}'

            if new_name[0] == '.':
                new_name = new_name[1:]

            toml_str += self._reparse_struct(value, tab=new_tab, name=new_name)

        if name == '':
            toml_str = toml_str.rstrip()

        return toml_str

    def _reparse_pair(self, key, value, tab='', name=''):
        r_val = self._reparse_value(value, tab, key)
        if r_val != 'null':
            return f'{self._reparse_key(key)} = {r_val}'
        return ''

    def _reparse_key(self, key_line):
        return self._reparse_key_string(key_line)

    def _reparse_value(self, value_line, tab='', name=''):
        if type(value_line) == list:
            return self._reparse_list(value_line, tab, name)
        else:
            return self._reparse_scalar(value_line)

    def _reparse_list(self, list_line, tab='', name=''):
        result_list = []
        if type(list_line[0]) != dict:

            for elem in list_line:
                result_list.append(self._reparse_value(elem, tab, name))
            return f'[ {", ".join(result_list)} ]'
        else:
            result_str = f'{tab}{name}'

            for elem in list_line:
                result_str += self._reparse_struct(elem, tab, name)

            return result_str

    def _reparse_scalar(self, scalar_line):
        if type(scalar_line) == int:
            return self._reparse_int(scalar_line)
        if type(scalar_line) == float:
            return self._reparse_int(scalar_line)
        if type(scalar_line) == str:
            return self._reparse_string(scalar_line)
        if type(scalar_line) == bool:
            return self._reparse_bool(scalar_line)
        if type(scalar_line) is None:
            return self._reparse_null()

    @staticmethod
    def _reparse_key_string(key_string_line):
        if ' ' not in key_string_line:
            return key_string_line
        return f'"{key_string_line}"'

    @staticmethod
    def _reparse_string(string_line):
        return f'"{string_line}"'

    @staticmethod
    def _reparse_bool(bool_line):
        if bool_line:
            return 'true'
        return 'false'

    @staticmethod
    def _reparse_int(int_line):
        return f"{int_line:_}"

    @staticmethod
    def _reparse_float(float_line):
        return f"{float_line:_}"

    @staticmethod
    def _reparse_null():
        return 'null'
