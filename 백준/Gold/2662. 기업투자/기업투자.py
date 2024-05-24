import sys
from copy import deepcopy
input = sys.stdin.readline

n, m = map(int, input().split())
invest = list()

for i in range(n):
    tmp = list(map(int, input().split()))
    invest.append(tmp)

dp = [[0]*(n+1) for _ in range(m+1)]
path = [[0]]

for i in range(1, n+1):
    dp[1][i] = invest[i-1][1]
    path.append([i])

for i in range(2, m+1):
    dp[i] = dp[i-1][:]
    path2 = []

    for j in range(n+1):
        path2.append(path[j][:])
        path2[j].append(0)

    for j in range(1, n+1):
        for k in range(j, n+1):
            if dp[i][k] < invest[j-1][i] + dp[i-1][k-j]:
                dp[i][k] = invest[j-1][i] + dp[i-1][k-j]
                path2[k] = path[k-j][:]
                path2[k].append(j)

    path = deepcopy(path2)

print(dp[m][n])
print(*path[n])
