import sys
input = sys.stdin.readline

d, p = map(int, input().split())
pipes = []

for i in range(p):
    pipes.append(tuple(map(int, input().split())))

dp = [1e9]+[0]*d

for i in range(p):
    dp2 = dp[:]

    for j in range(pipes[i][0], d+1):
        if dp2[j-pipes[i][0]]:
            dp[j] = max(dp[j], min(dp2[j-pipes[i][0]], pipes[i][1]))

print(dp[d])
