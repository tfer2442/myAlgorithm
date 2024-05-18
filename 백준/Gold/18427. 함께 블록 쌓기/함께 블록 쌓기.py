import sys
input = sys.stdin.readline

n, m, h = list(map(int, input().split()))

dp = [[0]*(h+1) for _ in range(n+1)]
dp[0][0] = 1

for i in range(1, n+1):
    block = list(map(int, input().split()))
    dp[i] = dp[i-1][:]
    for b in block:
        for j in range(b, h+1):
            dp[i][j] += dp[i-1][j-b]

print(dp[n][h]%10007)