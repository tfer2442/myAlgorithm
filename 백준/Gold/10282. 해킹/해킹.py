import sys
from heapq import heappush, heappop
input = sys.stdin.readline

t = int(input())
INF = 1e9

for _ in range(t):
    n, d, c = map(int, input().split())
    computer = {}

    for i in range(1, n+1):
        computer[i] = {}

    for _ in range(d):
        a, b, s = map(int, input().split())
        if a == b:
            continue
        computer[b][a] = s

    distance = [INF] * (n + 1)
    hq = list()
    heappush(hq, (0, c))
    distance[c] = 0

    while hq:
        value, node = heappop(hq)

        if value > distance[node]:
            continue

        for v in computer[node]:
            if (distance[node] != INF) and (distance[node] + computer[node][v] < distance[v]):
                heappush(hq, (distance[node] + computer[node][v], v))
                distance[v] = distance[node] + computer[node][v]
    maxValue = 0
    hacking = 0
    for num in distance:
        if num != INF:
            maxValue = max(maxValue, num)
            hacking += 1
    print(hacking, maxValue)