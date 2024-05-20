import sys
from heapq import heappush, heappop
input = sys.stdin.readline

n = int(input())
m = int(input())
graph = [{} for _ in range(n+1)]

for _ in range(m):
    s, e, v = map(int, input().split())
    if e in graph[s]:
        graph[s][e] = min(graph[s][e], v)
    else:
        graph[s][e] = v

start, end = map(int, input().split())

distance = [1e9] * (n+1)
distance[start] = 0
visited = [False] * (n+1)
hq = list()
heappush(hq, (0, start))
way = []

while hq:
    value, node = heappop(hq)

    if visited[node]:
        continue

    visited[node] = True

    for nextNode in graph[node]:
        nextValue = graph[node][nextNode]

        if distance[nextNode] > distance[node] + nextValue:
            distance[nextNode] = distance[node] + nextValue
            heappush(hq, (distance[nextNode], nextNode))
            way.append((node, nextNode))

findNode = end
answer = [findNode]
while way:
    s, e = way.pop()

    if e == findNode:
        answer.append(s)
        findNode = s

print(distance[end])
print(len(answer))
print(*answer[::-1])