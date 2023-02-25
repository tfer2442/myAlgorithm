import sys
input = sys.stdin.readline

n, m = map(int, input().split())

l = [[1]*101 for _ in range(101)]

for i in range(2, 101):
    for j in range(1, i):
        l[i][j] = l[i-1][j-1] + l[i-1][j]
print(l[n][m])