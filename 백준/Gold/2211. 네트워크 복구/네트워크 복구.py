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
heappush(hq, (0, start))
ways = []

while hq:
    value, node = heappop(hq)

    if value > distance[node]:
        continue

    for nextNode in graph[node]:
        nextValue = graph[node][nextNode] + value

        if distance[nextNode] > nextValue:
            heappush(hq, (nextValue, nextNode))
            distance[nextNode] = nextValue
            ways.append((node, nextNode))

result = []

for i in range(2, n+1):
    end = i
    for j in range(len(ways)-1, -1, -1):
        if ways[j][1] == end:
            node1 = min(ways[j][0], end)
            node2 = max(ways[j][0], end)
            result.append((node1, node2))
            end = ways[j][0]

result = set(result)

print(len(result))
for a, b in result:
    print(a, b)
