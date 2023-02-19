import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited_sum = []
for i in range(1, n+1):
    visited = [0] * (n + 1)
    d1 = deque()
    d1.append(i)
    visited[i] = 1

    while True:
        if not d1:
            break

        tmp = d1.popleft()

        for j in graph[tmp]:
            if not visited[j]:
                visited[j] = visited[tmp] + 1
                d1.append(j)
    visited_sum.append(sum(visited))
print(visited_sum.index(min(visited_sum)) + 1)

