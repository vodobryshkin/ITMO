from itertools import *
from Lab1 import calculateFibNumbers, tenToFibCS


def createTestList(c=10):
    testList = []

    for a in product("01", repeat=c):
        s = "".join(a)

        if "11" not in s:
            testList.append(s.lstrip("0"))

    return testList


def fibToTenCS(s):
    res = 0
    fibNumbers = calculateFibNumbers(len(s))[-1::-1] 
    for i in range(len(s)):
        res += int(s[i]) * fibNumbers[i]

    return str(res)


def createTestFile(c=10):
    testFile = open("testing.csv", mode="a")
    testList = createTestList(c)
    
    for elem in testList:
        tenFib = fibToTenCS(elem)

        testFile.write(f'{tenFib};{elem}\n')

    testFile.close()


def compareResults():
    testList = [[int(e.split(';')[0]), e.split(';')[1][:-1]] 
                for e in open("testing.csv", mode = "r").readlines()[:200000]]
    
    trueCounter, falseCounter = 0, 0

    for el1, el2 in testList:
        el3 = tenToFibCS(el1) 
        if el3 == el2:
            trueCounter += 1
        else:
            falseCounter += 1
            print(el1, el2, el3)

    print(f"Совпадений:{trueCounter}\nРазличий: {falseCounter}")


def main():
    compareResults()


if __name__ == "__main__":
    main()
