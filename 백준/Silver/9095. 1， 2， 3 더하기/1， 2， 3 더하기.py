import sys
input = sys.stdin.readline

T = int(input())

for i in range(T):
    n = int(input())
    dp = [0, 1, 2, 4, 7]
    if n <= 4:
        print(dp[n])
        continue
    for j in range(5, n+1):
        dp.append(dp[j-3] + dp[j-2] + dp[j-1])
    print(dp[n])
