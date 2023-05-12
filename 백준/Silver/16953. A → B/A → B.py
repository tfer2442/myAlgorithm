# 한줄로 서기

import sys
input = sys.stdin.readline


def one_num(b):
    b = b % 10

    if b == 1:
        return True
    else:
        return False


a, b = map(int, input().split())
cnt = 1
while True:
    if a == b:
        print(cnt)
        break
    if a > b:
        print(-1)
        break

    if b % 2 == 0:
        b = b//2
    elif one_num(b):
        b = b//10
    elif b % 2 == 1:
        print(-1)
        break
    cnt += 1
