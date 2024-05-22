import sys
input = sys.stdin.readline

n = int(input())
graph = []

for i in range(n):
    graph.append(list(map(int, input().split())))

for i in range(n):
    for j in range(n):
        if graph[i][j] == 0:
            graph[i][j] = float('inf')

for i in range(n):
    for j in range(n):
        for k in range(n):
            graph[i][j] = min(graph[i][j], graph[i][k]+graph[k][j])

for i in range(n):
    for j in range(n):
        for k in range(n):
            graph[i][j] = min(graph[i][j], graph[i][k]+graph[k][j])

for i in range(n):
    for j in range(n):
        if graph[i][j] != float('inf'):
            print(1, end=' ')
        else:
            print(0, end=' ')
    print()