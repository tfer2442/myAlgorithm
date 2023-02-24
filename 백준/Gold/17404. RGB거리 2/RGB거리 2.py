import sys
input = sys.stdin.readline

n = int(input())

l1 = [list(map(int, input().split())) for _ in range(n)]
result = 9999999
for j in range(3):
    dp = [[9999, 9999, 9999] for _ in range(n)]
    dp[0][j] = l1[0][j]
    for i in range(1, n):
        dp[i][0] = min(l1[i][0] + dp[i-1][1], l1[i][0] + dp[i - 1][2])
        dp[i][1] = min(l1[i][1] + dp[i-1][0], l1[i][1] + dp[i - 1][2])
        dp[i][2] = min(l1[i][2] + dp[i-1][1], l1[i][2] + dp[i - 1][0])

    for i in range(3):
        if i != j:
            result = min(result, dp[-1][i])
print(result)