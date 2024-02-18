import sys
from collections import Counter
input = sys.stdin.readline


def solution():
    if 'R' not in balls or 'B' not in balls:
        print(0)
        return

    firstBlueIndex = -1
    firstRedIndex = -1

    for i, ball in enumerate(balls):
        if firstBlueIndex != -1 and firstRedIndex != -1:
            break

        if firstBlueIndex == -1 and ball == 'B':
            firstBlueIndex = i

        if firstRedIndex == -1 and ball == 'R':
            firstRedIndex = i

    lastBlueIndex = -1
    lastRedIndex = -1

    for i, ball in enumerate(balls[::-1]):
        if lastBlueIndex != -1 and lastRedIndex != -1:
            break

        if lastBlueIndex == -1 and ball == 'B':
            lastBlueIndex = len(balls) - i - 1

        if lastRedIndex == -1 and ball == 'R':
            lastRedIndex = len(balls) - i - 1

    num1 = Counter(balls[:lastBlueIndex])['R']
    num2 = Counter(balls[:lastRedIndex])['B']
    num3 = Counter(balls[firstBlueIndex:])['R']
    num4 = Counter(balls[firstRedIndex:])['B']

    print(min(num1, num2, num3, num4))


n = int(input())
balls = list(input().strip())

solution()
