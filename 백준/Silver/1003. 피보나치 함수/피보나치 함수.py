T = int(input())

for i in range(T):
    n = int(input())

    dp = [0] * (n + 2)
    dp[0] = 1
    dp[1] = 0

    for j in range(2, n + 2):
        dp[j] = dp[j - 1] + dp[j - 2]

    print(dp[n], dp[n+1])