import sys
from itertools import product
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    l1 = []
    l2 = []
    n = int(input())

    for i in range(1, n):
        l1 = list(product([1, 2, 3], repeat=i))
        for j in l1:
            l2.append(j)
    cnt = 1
    for i in l2:
        if n == sum(i):
            cnt = cnt + 1
    print(cnt)
