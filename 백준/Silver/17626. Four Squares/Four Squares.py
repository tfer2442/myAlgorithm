import sys
from math import sqrt
input = sys.stdin.readline

n = int(input())
dp = [0] * (n+1)

for i in range(1, int(sqrt(n))+1):
    dp[i**2] = 1

if dp[n] == 1:
    print(1)
    exit(0)

for i in range(2, n+1):
    if dp[i] == 1:
        continue
    minValue = int(1e9)
    for j in range(1, int(sqrt(i))+1):
        minValue = min(minValue, dp[i - j**2])
        if minValue == 1:
            break
    dp[i] = minValue + 1

print(dp[n])

