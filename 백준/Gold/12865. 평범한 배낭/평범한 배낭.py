import sys
input = sys.stdin.readline

n, k = map(int, input().split())
dp = [[0]*(k+1) for _ in range(n+1)]
box = []

for i in range(n):
    box.append(list(map(int, input().split())))

box.sort(key=lambda x: (x[0], x[1]))
answer = 0

for i in range(1, n+1):
    for j in range(k+1):
        if j < box[i - 1][0]:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j - box[i - 1][0]] + box[i - 1][1])
        answer = max(dp[i][j], answer)

print(answer)