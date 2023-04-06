# 삼각형 위의 최대 경로

import sys
input = sys.stdin.readline

n = int(input())
l1 = []
dp = [[] for _ in range(n)]

for i in range(n):
    tmp = list(map(int, input().split()))
    l1.append(tmp)

for i in range(n):
    for j in range(len(l1[i])):
        dp[i].append(l1[i][j])

for i in range(1, n):
    for j in range(len(dp[i])):
        if j == 0:
            dp[i][j] = dp[i-1][j] + dp[i][j]
        elif j == len(dp[i])-1:
            dp[i][j] = dp[i-1][j-1] + dp[i][j]
        else:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-1]) + dp[i][j]

maxint = -9999
location = n-1
s = []
for i in range(n-1, -1, -1):
    if maxint < dp[n-1][i]:
        maxint = dp[n-1][i]
        location = i
s.append(l1[n-1][location])

for i in range(n-1, 0, -1):
    if location == 0:
        s.append(l1[i - 1][location])
    elif location == len(l1[i]) - 1:
        location = location-1
        s.append(l1[i-1][location])
    elif dp[i][location] == dp[i-1][location-1] + l1[i][location]:
        location = location-1
        s.append(l1[i-1][location])
    elif dp[i][location] == dp[i-1][location] + l1[i][location]:
        s.append(l1[i - 1][location])

print(max(dp[n-1]))


