import sys

input = sys.stdin.readline

inf = 1e9
ddr = list(map(int, input().split()))
dp = [[[inf]*5 for _ in range(5)] for _ in range(100001)]
distance = [[1, 2, 2, 2, 2],
            [2, 1, 3, 4, 3],
            [2, 3, 1, 3, 4],
            [2, 4, 3, 1, 3],
            [2, 3, 4, 3, 1]]

dp[0][0][0] = 0

for i in range(1, len(ddr)):
    cur = ddr[i-1]

    for j in range(5):
        for k in range(5):
            dp[i][j][cur] = min(dp[i][j][cur], dp[i-1][j][k] + distance[k][cur])

    for j in range(5):
        for k in range(5):
            dp[i][cur][j] = min(dp[i][cur][j], dp[i-1][k][j] + distance[k][cur])

answer = inf
for i in range(5):
    for j in range(5):
        answer = min(answer, dp[len(ddr)-1][i][j])

print(answer)

