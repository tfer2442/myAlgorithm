import sys
from collections import deque
input = sys.stdin.readline


n, m = map(int, input().split())
graph = [{} for _ in range(n+1)]
inDegree = [0] * (n+1)

for _ in range(m):
    start, end = map(int, input().split())
    graph[start][end] = True
    inDegree[end] += 1

q = deque()

for i in range(1, n+1):
    if inDegree[i] == 0:
        q.append(i)

while q:
    curNode = q.popleft()
    print(curNode, end=' ')

    for nextNode in graph[curNode]:
        inDegree[nextNode] -= 1
        if inDegree[nextNode] == 0:
            q.append(nextNode)
