import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline


def dfs(node):
    visited[node] = True

    for nextNode in graph[node]:
        if not visited[nextNode]:
            dfs(nextNode)


n, m = map(int, input().split())
graph = [{} for _ in range(n+1)]

for i in range(m):
    u, v = map(int, input().split())
    graph[u][v] = True
    graph[v][u] = True

visited = [False] * (n+1)
cnt = 0

for i in range(1, n+1):
    if not visited[i]:
        dfs(i)
        cnt += 1

print(cnt)