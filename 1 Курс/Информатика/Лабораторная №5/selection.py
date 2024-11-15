from itertools import *


def binary_sum(a, b, ost=0):
    res = a + b + ost
    if res == 2:
        return 0, 1
    if res == 3:
        return 1, 1

    return res, 0


def checker(zn, a1, a2, b1, b2, b3):
    nb3, ost = binary_sum(b1, b2)

    if nb3 != b3:
        if b3 == 0:
            ost = 1

    a3, _ = binary_sum(a1, a2, ost)
    if a3 == zn:
        return [[a1, a2], [b1, b2, b3]]
    return []


ones = []
for a1, a2, b1, b2, b3 in product([0, 1], repeat=5):
    res = checker(1, a1, a2, b1, b2, b3)
    if len(res) > 0 and res[0][0] != res[0][1]:
        ones.append(res)

print(*ones, sep='\n')
