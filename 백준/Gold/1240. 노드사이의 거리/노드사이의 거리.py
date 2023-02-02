import sys
input = sys.stdin.readline;

def dfs(v, d):
    visited[v] = True
    if v == e:
        print(d)
        return

    for i in graph[v]:
        if not visited[i]:
           dfs(i, d+dist[v][i])

    if len(graph[v]) == 1 and v != 1:
        return

def visited_init(m):
    for i in range(m+1):
        visited[i] = False


m, n = map(int, input().split())

graph = [[] for _ in range(m+1)]
visited = [False] * (m+1)
dist = [[0]*(m+1) for _ in range(m+1)]

for i in range(m-1):
    a, b, c = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
    dist[a][b] = c
    dist[b][a] = c

for i in range(n):
    global e
    s, e = map(int, input().split())
    dfs(s, 0)
    visited_init(m)
