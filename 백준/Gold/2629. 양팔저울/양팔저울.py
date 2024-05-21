import sys
input = sys.stdin.readline

n = int(input())
balanceWeight = list(map(int, input().split()))
m = int(input())
marble = list(map(int, input().split()))

dp = [[0]*40001 for _ in range(n+1)]
total = sum(balanceWeight)

for i in range(1, n+1):
    dp[i] = dp[i-1][:]
    value = balanceWeight[i-1]
    dp[i][value] += 1

    for j in range(1, value):
        prevValue = dp[i-1][j]

        if prevValue >= 1:
            dp[i][value+j] += 1
            dp[i][value-j] += 1

    for j in range(value, 40001):
        prevValue = dp[i-1][j]

        if prevValue >= 1:
            dp[i][value+j] += 1
            dp[i][j-value] += 1


for i in range(m):
    if dp[n][marble[i]] >= 1:
        print('Y', end=' ')
    else:
        print('N', end=' ')
