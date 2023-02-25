import sys
input = sys.stdin.readline

n, m = map(int, input().split())

l = [[1]*(n+1) for _ in range(n+1)]

if m == 0 or n == m:
    print(1)
    exit(0)
for i in range(2, n+1):
    for j in range(1, i):
        l[i][j] = l[i-1][j-1] + l[i-1][j]
print(l[n][m])