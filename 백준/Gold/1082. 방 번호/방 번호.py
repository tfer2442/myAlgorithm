import sys
input = sys.stdin.readline

n = int(input())
p = list(map(int, input().split()))
m = int(input())

dp = [-100000] * (m+1)

for i in range(n-1, -1, -1):
    value = p[i]

    for j in range(value, m+1):
        dp[j] = max(dp[j-value]*10+i, i, dp[j])

print(dp[-1])