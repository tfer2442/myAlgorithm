import sys
from collections import deque
input = sys.stdin.readline


def bfs(startX, startY, endX, endY):
    q = deque()
    q.append(((startX, startY), 0))
    visited[startX][startY] = True

    while q:
        node, cur = q.popleft()

        if node[0] == endX and node[1] == endY:
            print(cur)
            break

        for dr, dc in d:
            nr, nc = node[0] + dr, node[1] + dc

            if 0 <= nr < n and 0 <= nc < n and not visited[nr][nc]:
                visited[nr][nc] = True
                q.append(((nr, nc), cur+1))


T = int(input())
d = [(-1, -2), (-2, -1), (-2, 1), (-1, 2), (1, 2), (2, 1), (2, -1), (1, -2)]

for _ in range(T):
    n = int(input())
    startX, startY = map(int, input().split())
    endX, endY = map(int, input().split())
    visited = [[False]*n for _ in range(n)]
    bfs(startX, startY, endX, endY)
    