import sys
from heapq import heappush, heappop

input = sys.stdin.readline

n, m = map(int, input().split())
graph = [{} for _ in range(n+1)]

for _ in range(m):
    s, e, v = map(int, input().split())

    if e in graph[s]:
        graph[s][e] = min(graph[s][e], v)
        graph[e][s] = min(graph[e][s], v)
        continue
    graph[s][e] = v
    graph[e][s] = v

distance = [float('inf')] * (n+1)
hq = list()

start = 1
distance[start] = 0
heappush(hq, (0, start, 0))
ways = []

while hq:
    value, node, prev = heappop(hq)

    if value > distance[node]:
        continue
    ways.append((prev, node))

    for nextNode in graph[node]:
        nextValue = graph[node][nextNode] + value

        if distance[nextNode] > nextValue:
            heappush(hq, (nextValue, nextNode, node))
            distance[nextNode] = nextValue


print(len(ways)-1)
for i in range(1, len(ways)):
    print(ways[i][0], ways[i][1])