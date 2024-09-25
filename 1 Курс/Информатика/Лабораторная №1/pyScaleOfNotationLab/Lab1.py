def calculateFibNumbers(n):
    fibNumbers = [0] * (n + 2)
    fibNumbers[1] = 1
    
    for i in range(2, n + 2):
        fibNumbers[i] = fibNumbers[i - 1] + fibNumbers[i - 2]

    return fibNumbers[2:]


def calculateIndexOfClosestFib(n, fibSize=10000):
    l, r = 0, fibSize
    fibNumbers = calculateFibNumbers(fibSize)

    while r - l > 1:
        m = (r + l) // 2

        if fibNumbers[m] > n:
            r = m
        else:
            l = m

    return r


def tenToFibCS(n):
    if n == 0:
        return "0"

    result = ""
    
    fibNumbers = calculateFibNumbers(calculateIndexOfClosestFib(n))[-1::-1]
    intermN = n
    i, f = 0, True

    while i < len(fibNumbers):
        if f and n - fibNumbers[i] >= 0:
            result += "10"
            n -= fibNumbers[i]
            i += 2
        elif f and n - fibNumbers[i] < 0:
            result += "0"
            i += 1

    if len(result) != len(fibNumbers):
        result = result[:-1]
    
    return result


def main():
    print(tenToFibCS(int(input())))

if __name__ == "__main__":
    main()
