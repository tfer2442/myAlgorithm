# 트로미노 퍼즐

import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)


def divide_matrix(n, sX, sY):
    global cnt
    if n == 2:
        for i in range(sY, sY + n):
            for j in range(sX, sX + n):
                if l1[i][j] == 0:
                    l1[i][j] = cnt
        cnt += 1
        return
    else:
        fill_matrix(n, sX, sY)

    divide_matrix(n // 2, sX, sY)
    divide_matrix(n // 2, sX + n // 2, sY)
    divide_matrix(n // 2, sX, sY + n // 2)
    divide_matrix(n // 2, sX + n // 2, sY + n // 2)


def fill_matrix(k, sX, sY):
    global cnt
    a = 0
    b = 0

    for i in range(sY, sY + k):
        for j in range(sX, sX + k):
            if l1[i][j] != 0:
                a = i
                b = j

    i = a
    j = b

    if i < sY + k // 2 and j < sX + k // 2:
        l1[k // 2 + sY - 1][k // 2 + sX] = cnt # 2사
        l1[k // 2 + sY][k // 2 + sX - 1] = cnt # 3사
        l1[k // 2 + sY][k // 2 + sX] = cnt # 4사
    elif i < sY + k // 2 and j >= sX + k // 2:
        l1[k // 2 + sY - 1][k // 2 + sX - 1] = cnt # 1사
        l1[k // 2 + sY][k // 2 + sX - 1] = cnt # 3사
        l1[k // 2 + sY][k // 2 + sX] = cnt # 4사
    elif i >= sY + k // 2 and j < sX + k // 2:
        l1[k // 2 + sY - 1][k // 2 + sX - 1] = cnt # 1사
        l1[k // 2 + sY - 1][k // 2 + sX] = cnt # 2사
        l1[k // 2 + sY][k // 2 + sX] = cnt # 4사
    elif i >= sY + k // 2 and j >= sX + k // 2:
        l1[k // 2 + sY - 1][k // 2 + sX - 1] = cnt # 1사
        l1[k // 2 + sY][k // 2 + sX - 1] = cnt # 3사
        l1[k // 2 + sY - 1][k // 2 + sX] = cnt # 2사
    cnt += 1


n = int(input())
r, c = map(int, input().split())
n = 2**n

l1 = [[0] * (n + 1) for _ in range(n + 1)]
l1[n-c+1][r] = -1

cnt = 1
divide_matrix(n, 1, 1)

for i in range(1, n+1):
    for j in range(1, n+1):
        if j != n:
            print(l1[i][j], end=' ')
        else:
            print(l1[i][j])
