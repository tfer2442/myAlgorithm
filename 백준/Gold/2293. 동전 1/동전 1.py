import sys
input = sys.stdin.readline

n, k = map(int, input().split())
coins = []
dp = [1]+[0]*k

for _ in range(n):
    coins.append(int(input()))

for i in range(1, n+1):
    for j in range(1, k+1):
        if j-coins[i-1] >= 0:
            dp[j] = dp[j-coins[i-1]] + dp[j]

print(dp[-1])