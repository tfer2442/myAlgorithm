import sys
input = sys.stdin.readline

n = int(input())

if n % 2 == 1:
    print(0)
else:
    dp = [1, 0, 3, 0, 11] + [0] * 26

    for i in range(6, n+1, 2):
        dp[i] = dp[i-2] * 3 + sum(dp[:i-3]) * 2
    print(dp[n])