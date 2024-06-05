import sys
input = sys.stdin.readline

C, N = map(int, input().split())
cities = []
maxValue = -1
for _ in range(N):
    tmp = list(map(int, input().split()))
    maxValue = max(maxValue, tmp[1])
    cities.append(tmp)

dp = [0] + [int(1e9)] * (C+maxValue-1)

for w, p in cities:
    for i in range(p, C+maxValue):
        dp[i] = min(dp[i], dp[i-p]+w)

print(min(dp[C:]))
