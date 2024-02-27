import sys
input = sys.stdin.readline


n = int(input())
table = []
dp = [[0, 0, 0] for _ in range(2)]
dp2 = [[0, 0, 0] for _ in range(2)]

dp[0][0], dp[0][1], dp[0][2] = map(int, input().split())
dp2[0][0], dp2[0][1], dp2[0][2] = dp[0][0], dp[0][1], dp[0][2]

if n == 1:
    print(max(dp[0]), min(dp[0]))
    exit(0)


for i in range(1, n):
    a, b, c = map(int, input().split())
    dp[1][0] = max(dp[0][0] + a, dp[0][1] + a)
    dp[1][1] = max(dp[0][0] + b, dp[0][1] + b, dp[0][2] + b)
    dp[1][2] = max(dp[0][1] + c, dp[0][2] + c)

    dp2[1][0] = min(dp2[0][0] + a, dp2[0][1] + a)
    dp2[1][1] = min(dp2[0][0] + b, dp2[0][1] + b, dp2[0][2] + b)
    dp2[1][2] = min(dp2[0][1] + c, dp2[0][2] + c)

    dp[0][0], dp[0][1], dp[0][2] = dp[1][0], dp[1][1], dp[1][2]
    dp2[0][0], dp2[0][1], dp2[0][2] = dp2[1][0], dp2[1][1], dp2[1][2]


print(max(dp[1]), min(dp2[1]))




