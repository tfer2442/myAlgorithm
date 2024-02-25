import sys
input = sys.stdin.readline


n = int(input())
house = [list(map(int, input().split())) for _ in range(n)]
dp = [[[0] * 3 for _ in range(n)] for _ in range(n)]
if house[n-1][n-1] == 1:
    print(0)
    exit(0)

for i in range(1, n):
    if house[0][i] == 1:
        break
    dp[0][i][0] = 1

for i in range(1, n):
    for j in range(2, n):

        if house[i][j] == 1:
            continue

        if house[i][j-1] != 1:
            dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2]

        if house[i-1][j] != 1:
            dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2]

        if house[i-1][j-1] != 1 and house[i][j-1] != 1 and house[i-1][j] != 1:
            dp[i][j][2] = sum(dp[i-1][j-1])

print(sum(dp[n-1][n-1]))
