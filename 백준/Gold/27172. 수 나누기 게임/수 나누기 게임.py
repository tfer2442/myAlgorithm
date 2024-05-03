import sys
input = sys.stdin.readline


def setDivisor(num):
    divideNums[num] = {1: True}

    for i in range(2, int(num**(1/2)) + 1):
        if num % i == 0:
            divideNums[num][i] = True
            if (i**2) != num:
                divideNums[num][num//i] = True


n = int(input())
cards = list(map(int, input().split()))
vs = {card: 0 for card in cards}
divideNums = {}

for card in cards:
    setDivisor(card)

for card in cards:
    for divisor in divideNums[card]:
        if divisor in vs:
            vs[card] -= 1
            vs[divisor] += 1


for card in cards:
    print(vs[card], end=' ')
