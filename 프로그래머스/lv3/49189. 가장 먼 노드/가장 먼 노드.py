from collections import deque

def solution(n, edge):
    visited = [False] * (n+1)
    dist = [0] * (n+1)
    visited[0] = True
    graph = [[] for _ in range(n+1)]
    l1 = deque()

    for i in range(len(edge)):
        graph[edge[i][0]].append(edge[i][1])
        graph[edge[i][1]].append(edge[i][0])

    l1.append(1)
    visited[1] = True

    while True:
        if all(visited):
            break
        a = l1.popleft()

        for i in range(len(graph[a])):
            if not visited[graph[a][i]]:
                l1.append(graph[a][i])
                visited[graph[a][i]] = True
                dist[graph[a][i]] = dist[a] + 1
    md = max(dist)
    num = 0
    for i in range(1, n+1):
        if dist[i] == md:
            num += 1
    answer = num

    return answer