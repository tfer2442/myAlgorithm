import sys
from collections import deque
input = sys.stdin.readline
sys.setrecursionlimit(10**7)


def dfs(v):
    for tmp in graph[v]:
        if not visited[tmp]:
            visited[tmp] = True
            print(tmp, end=' ')
            dfs(tmp)


n, m, v = map(int, input().split())
graph = [[] for _ in range(n+1)]

for i in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1, n+1):
    graph[i].sort()
visited = [False] * (n+1)
visited[v] = True
print(v, end=' ')
dfs(v)
print()

visited = [False] * (n+1)
bfsl = deque()
bfsl.append(v)
visited[v] = True
while True:
    if not bfsl:
        break
    tmp = bfsl.popleft()
    print(tmp, end=' ')

    for i in graph[tmp]:
        if not visited[i]:
            visited[i] = True
            bfsl.append(i)
