import sys
from heapq import heappush, heappop
input = sys.stdin.readline

n = int(input())
m = int(input())

maxValue = int(1e9)
minDist = [maxValue] * (n+1)
q = []
edges = {}

for i in range(1, n+1):
    edges[i] = {}

for _ in range(m):
    start, end, value = map(int, input().split())

    if end in edges[start]:
        edges[start][end] = min(edges[start][end], value)
    else:
        edges[start][end] = value

start, end = map(int, input().split())
minDist[start] = 0
heappush(q, (0, start))

while q:
    value, vertex = heappop(q)

    if minDist[vertex] < value:
        continue

    for v in edges[vertex]:
        if minDist[vertex] + edges[vertex][v] < minDist[v]:
            minDist[v] = edges[vertex][v] + minDist[vertex]
            heappush(q, (minDist[v], v))

print(minDist[end])