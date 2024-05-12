import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())

board = []

for _ in range(n):
    board.append(input().strip())

visited = [[[False]*m for _ in range(n)] for _ in range(2)]

d = [(0, 1), (1, 0), (-1, 0), (0, -1)]
q = deque()
q.append(((0, 0), False, 1))
visited[0][0][0] = True

while q:
    node, coin, cur = q.popleft()

    if node[0] == n-1 and node[1] == m-1:
        print(cur)
        break

    for dr, dc in d:
        nr, nc = node[0] + dr, node[1] + dc

        if 0 <= nr < n and 0 <= nc < m:
            if board[nr][nc] == '1' and not visited[1][nr][nc] and not coin:
                visited[1][nr][nc] = True
                q.append(((nr, nc), True, cur+1))
            elif board[nr][nc] == '0':
                if coin and not visited[1][nr][nc]:
                    visited[1][nr][nc] = True
                    q.append(((nr, nc), True, cur+1))
                elif not coin and not visited[0][nr][nc]:
                    visited[0][nr][nc] = True
                    q.append(((nr, nc), False, cur+1))
else:
    print(-1)
