import sys
input = sys.stdin.readline

n, m = map(int, input().split())
graph = {}
edges = []
INF = 10000000000

for i in range(1, n+1):
    graph[i] = {}

for i in range(m):
    a, b, c = map(int, input().split())
    graph[a][b] = c
    edges.append((a, b, c))


def bellmanford(start):
    distance[start] = 0

    for i in range(n):
        for s, e, w in edges:
            if distance[s] != INF and distance[e] > distance[s] + w:
                distance[e] = distance[s] + w
                if i == n-1:
                    return False
    return True


distance = [INF] * (n+1)
if bellmanford(1):
    for i in range(2, n+1):
        if distance[i] == INF:
            print(-1)
            continue
        print(distance[i])
else:
    print(-1)
