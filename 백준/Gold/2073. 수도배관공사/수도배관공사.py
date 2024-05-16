import sys
input = sys.stdin.readline

d, p = map(int, input().split())
pipes = []

for i in range(p):
    pipes.append(tuple(map(int, input().split())))

dp = [1e9]+[0]*d

for i in range(p):
    for j in range(d, pipes[i][0]-1, -1):
        dp[j] = max(dp[j], min(dp[j-pipes[i][0]], pipes[i][1]))

print(dp[d])
