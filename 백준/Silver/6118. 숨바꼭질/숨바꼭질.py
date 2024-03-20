import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
l1 = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    l1[a].append(b)
    l1[b].append(a)

visited = [False] * (n+1)
distance = [0] * (n+1)
q = deque()
q.append((1, 0))
visited[1] = True

while q:
    node, depth = q.pop()

    for i in l1[node]:
        if not visited[i]:
            visited[i] = True
            distance[i] = depth+1
            q.appendleft((i, depth+1))

maxDistance = max(distance)
print(distance.index(maxDistance), maxDistance, distance.count(maxDistance))

