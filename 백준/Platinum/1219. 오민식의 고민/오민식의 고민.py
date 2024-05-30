import sys
from collections import deque
input = sys.stdin.readline


def bfs(s, e):
    q = deque()
    visited = [False] * n
    q.append(s)

    while q:
        curNode = q.popleft()

        if curNode == e:
            return True
        visited[curNode] = True

        for next in graph[curNode]:
            if not visited[next]:
                q.append(next)

    return False


n, start, end, m = map(int, input().split())
edges = []
graph = [{} for _ in range(n)]

for _ in range(m):
    s, e, v = map(int, input().split())
    edges.append([s, e, v])
    graph[s][e] = v

tmp = list(map(int, input().split()))
profit = {i: tmp[i] for i in range(n)}

for i in range(m):
    money = profit[edges[i][1]]
    edges[i] = [edges[i][0], edges[i][1], edges[i][2]-money]

INF = int(1e11)
distance = [INF] * n
distance[start] = -profit[start]

for i in range(n):
    for edge in edges:
        if distance[edge[0]] != INF and distance[edge[0]] + edge[2] < distance[edge[1]]:
            distance[edge[1]] = distance[edge[0]] + edge[2]

            if i == n-1 and bfs(edge[1], end):
                print("Gee")
                exit(0)

if distance[end] == INF:
    print("gg")
else:
    print(-distance[end])

