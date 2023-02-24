import sys
from collections import deque
input = sys.stdin.readline


m, n = map(int, input().split())
l1 = []
q = deque()
visited = [[0]*m for _ in range(n)]

for _ in range(n):
    l1.append(list(map(int, input().split())))

for i in range(n):
    for j in range(m):
        if l1[i][j] == 1:
            q.append([i, j])

while True:
    if not q:
        break
    row, col = q.popleft()

    if row - 1 >= 0 and l1[row - 1][col] == 0:
        l1[row - 1][col] = l1[row][col] + 1
        q.append([row - 1, col])
    if row + 1 <= n - 1 and l1[row + 1][col] == 0:
        l1[row + 1][col] = l1[row][col] + 1
        q.append([row + 1, col])
    if col - 1 >= 0 and l1[row][col - 1] == 0:
        l1[row][col - 1] = l1[row][col] + 1
        q.append([row, col - 1])
    if col + 1 <= m - 1 and l1[row][col + 1] == 0:
        l1[row][col + 1] = l1[row][col] + 1
        q.append([row, col + 1])
if all(map(all, l1)):
    print(max(map(max, l1)) - 1)
else:
    print(-1)
