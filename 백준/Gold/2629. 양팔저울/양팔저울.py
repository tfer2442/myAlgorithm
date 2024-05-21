import sys
input = sys.stdin.readline

n = int(input())
balanceWeight = list(map(int, input().split()))
m = int(input())
marble = list(map(int, input().split()))

total = sum(balanceWeight)
dp = [[0]*(total+1) for _ in range(n+1)]

for i in range(1, n+1):
    dp[i] = dp[i-1][:]
    value = balanceWeight[i-1]
    dp[i][value] = 1

    for j in range(1, total+1):
        if dp[i-1][j] >= 1:
            dp[i][value+j] = 1
            dp[i][abs(value-j)] = 1

for i in range(m):
    if marble[i] <= total and dp[n][marble[i]] >= 1:
        print('Y', end=' ')
    else:
        print('N', end=' ')
