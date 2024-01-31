import sys
from itertools import combinations

input = sys.stdin.readline

INF = 1e9

def updateMinLength(v, graph):
    for k in range(1, v+1):
        for i in range(1, v+1):
            if graph[i][k] == INF:
                continue
            for j in range(1, v+1):
                if graph[k][j] == INF:
                    continue
                graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])


v, e = map(int, input().split())
graph = [[INF] * (v+1) for _ in range(v+1)]

for _ in range(e):
    a, b, c = map(int, input().split())
    graph[a][b] = c

updateMinLength(v, graph)
cycleLength = []

for i in range(1, v+1):
    if graph[i][i] == INF:
        continue
    cycleLength.append(graph[i][i])

if cycleLength:
    print(min(cycleLength))

if not cycleLength:
    print(-1)
