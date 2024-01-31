import sys
from itertools import combinations

input = sys.stdin.readline

INF = 1e9


def initGraph(v, graph):
    for i in range(1, v+1):
        graph[i][i] = 0


def updateMinLength(v, graph):
    for k in range(1, v+1):
        for i in range(1, v+1):
            for j in range(1, v+1):
                if graph[i][k] == INF or graph[k][j] == INF:
                    continue
                graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])


v, e = map(int, input().split())
graph = [[INF] * (v+1) for _ in range(v+1)]

initGraph(v, graph)

for _ in range(e):
    a, b, c = map(int, input().split())
    graph[a][b] = c

updateMinLength(v, graph)
cycleLength = []

for start, end in combinations(range(1, v+1), 2):
    if graph[start][end] == INF or graph[end][start] == INF:
        continue
    cycleLength.append(graph[start][end] + graph[end][start])

if cycleLength:
    print(min(cycleLength))

if not cycleLength:
    print(-1)
