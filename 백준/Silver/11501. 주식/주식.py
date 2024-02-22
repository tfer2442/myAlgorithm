import sys
input = sys.stdin.readline

T = int(input())

for i in range(T):
    n = int(input())
    kospi = list(map(int, input().split()))
    maxValue = -1
    maxList = [0] * len(kospi)
    profit = 0

    for j in range(len(kospi)-1, -1, -1):
        if kospi[j] >= maxValue:
            maxList[j] = kospi[j]
            maxValue = maxList[j]
        else:
            maxList[j] = maxValue

    for j in range(len(kospi)):
        profit += maxList[j] - kospi[j]
    print(profit)
