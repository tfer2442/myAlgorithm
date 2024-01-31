import sys
from heapq import heappush, heappop
input = sys.stdin.readline

v, e = map(int, input().split())
start = int(input())

MAX_VALUE = int(1e9)
graph = {}
distance = [MAX_VALUE] * (v+1)
distance[start] = 0
heap = []
heappush(heap, (0, start))

for i in range(1, v+1):
    graph[i] = []

for _ in range(e):
    s, e, value = map(int, input().split())
    graph[s].append((e, value))

visited = [False] * (v+1)

while heap:
    value, node = heappop(heap)
    if visited[node]:
        continue
    visited[node] = True
    for newNode, newValue in graph[node]:
        if distance[newNode] <= value + newValue:
            continue
        distance[newNode] = value + newValue
        heappush(heap, (value+newValue, newNode))

for i in range(1, v+1):
    if distance[i] == MAX_VALUE:
        print('INF')
        continue
    print(distance[i])
