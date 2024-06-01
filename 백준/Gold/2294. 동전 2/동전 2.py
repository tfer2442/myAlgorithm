import sys
input = sys.stdin.readline

n, k = map(int, input().split())
coins = set()

for _ in range(n):
    coins.add(int(input()))

maxValue = int(1e11)
dp = [0] + [maxValue] * k

for coin in coins:
    for i in range(coin, k+1):
        dp[i] = min(dp[i-coin] + 1, dp[i])

if dp[-1] == maxValue:
    print(-1)
else:
    print(dp[-1])
