import sys
from math import ceil

input = sys.stdin.readline

c, n = map(int, input().split())
cities = []

for _ in range(n):
    w, p = map(int, input().split())

    num = ceil(c/p)
    cnt = 1
    while True:
        num -= cnt

        if num <= 0:
            num += cnt
            cities.append([w*num, p*num])
            break

        cities.append([w*cnt, p*cnt])
        cnt *= 2

dp = [[0] * 100001 for _ in range(len(cities)+1)]
minValue = int(1e9)
for i in range(1, len(cities)+1):
    w, p = cities[i-1]

    for j in range(100001):
        if j < w:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-w] + p)
        if dp[i][j] >= c:
            minValue = min(minValue, j)

print(minValue)