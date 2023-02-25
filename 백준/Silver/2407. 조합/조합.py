import sys
from itertools  import combinations
input = sys.stdin.readline

n, m = map(int, input().split())

l = [[0]*101 for _ in range(101)]
for i in range(1, 101):
    l[i][0] = 1
l[1][1] = 1
for i in range(2, 101):
    for j in range(1, i+1):
        if l[i-1][j] == 0:
            l[i][j] = 1
            break
        l[i][j] = l[i-1][j-1] + l[i-1][j]
print(l[n][m])