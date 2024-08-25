import sys
input = sys.stdin.readline

N, K = map(int, input().split())
dp = [[1] * (N+1) for _ in range(K)]

for i in range(1, K):
    for j in range(1, N+1):
        dp[i][j] = (dp[i-1][j] + dp[i][j-1])

print(dp[K-1][N] % 1_000_000_000)