import sys
input = sys.stdin.readline

n, k = map(int, input().split())
coins = []
dp = [1]+[0]*k

for _ in range(n):
    coins.append(int(input()))

for i in range(n):
    for j in range(coins[i], k+1):
        dp[j] = dp[j-coins[i]] + dp[j]

print(dp[-1])