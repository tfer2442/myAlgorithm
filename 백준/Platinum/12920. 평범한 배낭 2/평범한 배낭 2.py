import sys
input = sys.stdin.readline

n, m = map(int, input().split())
bags = [(0, 0)]

for _ in range(n):
    v, c, k = map(int, input().split())

    cnt = 1

    while True:
        k -= cnt

        if k <= 0:
            k += cnt
            bags.append((v*k, c*k))
            break

        bags.append((v*cnt, c*cnt))
        cnt *= 2

dp = [[0]*(m+1) for _ in range(len(bags))]

for i in range(len(bags)):
    if bags[i][0] > m:
        continue
    for j in range(m+1):
        if bags[i][0] > j:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-bags[i][0]] + bags[i][1])

print(dp[-1][m])
