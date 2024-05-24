import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline


def dfs(node):
    global total
    global cnt

    visited[node] = True
    cnt += 1
    total += candy[node]

    for nextNode in graph[node]:
        if not visited[nextNode]:
            dfs(nextNode)


n, m, k = map(int, input().split())
candy = [0] + list(map(int, input().split()))
graph = [{} for _ in range(n+1)]

for i in range(m):
    a, b = map(int, input().split())
    graph[a][b] = True
    graph[b][a] = True

visited = [False] * (n+1)
result = [(0, 0)]
for i in range(1, n+1):
    total = 0
    cnt = 0
    if not visited[i]:
        dfs(i)
        result.append((cnt, total))

dp = [[0] * k for _ in range(len(result))]
for j in range(k):
    for i in range(1, len(result)):
        if j < result[i][0]:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-result[i][0]]+result[i][1])

print(dp[len(result)-1][k-1])
