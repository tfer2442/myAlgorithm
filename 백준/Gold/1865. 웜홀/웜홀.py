import sys
input = sys.stdin.readline


def solution():
    n, m, w = map(int, input().split())
    graph = [{} for _ in range(n+1)]

    for i in range(m):
        s, e, v = map(int, input().split())

        if e not in graph[s]:
            graph[s][e] = v
            graph[e][s] = v
        else:
            graph[s][e] = min(graph[s][e], v)
            graph[e][s] = min(graph[s][e], v)

    for i in range(w):
        s, e, v = map(int, input().split())

        if e not in graph[s]:
            graph[s][e] = -v
        else:
            graph[s][e] = min(graph[s][e], -v)

    INF = int(1e9)
    distance = [INF] * (n+1)
    start = 1
    distance[start] = 0

    for i in range(n):
        for j in range(1, n+1):
            for k in graph[j]:
                if distance[k] > distance[j] + graph[j][k]:
                    distance[k] = distance[j] + graph[j][k]

                    if i == n-1:
                        print('YES')
                        return
    print('NO')


T = int(input())

for _ in range(T):
    solution()