# # 최장공통부분서열(LCS)

import sys
input = sys.stdin.readline


def lcs(x, y):
    lenx = len(x)
    leny = len(y)

    for i in range(1, leny + 1):
        for j in range(1, lenx + 1):
            if y[i - 1] == x[j - 1]:
                dp[i][j] = dp[i - 1][j - 1] + 1
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

    return dp[leny][lenx]

x = input().rstrip()
y = input().rstrip()
lenx = len(x)
leny = len(y)
if lenx < leny:
    x, y = y, x
    lenx, leny = leny, lenx

dp = [[0] * (lenx + 1) for _ in range(leny + 1)]

lcs_len = lcs(x, y)
print(lcs_len)