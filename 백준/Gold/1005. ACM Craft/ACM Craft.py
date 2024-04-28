import sys
from collections import deque
input = sys.stdin.readline


def solution():
    n, k = map(int, input().split())
    l1 = list(map(int, input().split()))
    graph = [{} for _ in range(n+1)]

    for i in range(k):
        x, y = map(int, input().split())
        graph[y][x] = True
    w = int(input())
    distance = [-1] * (n+1)
    distance[w] = l1[w-1]

    d = deque()
    d.append(w)

    while d:
        node = d.popleft()

        for v in graph[node]:
            if distance[v] == -1 or distance[v] < distance[node]+l1[v-1]:
                distance[v] = l1[v-1] + distance[node]
                d.append(v)

    print(max(distance))


T = int(input())

for t in range(T):
    solution()
