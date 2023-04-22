# 회의실 배정 : 활통 선택 문제

import sys
input = sys.stdin.readline

n = int(input())
l1 = list()

for _ in range(n):
    a, b = map(int, input().split())
    l1.append([a, b])

l1.sort(key=lambda x: (x[1], x[0]))
l2 = list()
l2.append(l1[0])
tmp = 0

for i in range(1, n):
    if l1[tmp][1] <= l1[i][0]:
        l2.append(l1[i])
        tmp = i

print(len(l2))


