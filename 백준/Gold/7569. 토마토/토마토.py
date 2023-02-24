import sys
from collections import deque

input = sys.stdin.readline

m, n, l = map(int, input().split())
q = deque()
l1 = [[[0] * m for _ in range(n)] for _ in range(l)]

for i in range(l):
    for j in range(n):
        tmp = list(map(int, input().split()))
        l1[i][j] = tmp

for k in range(l):
    for i in range(n):
        for j in range(m):
            if l1[k][i][j] == 1:
                q.append([k, i, j])

while True:
    if not q:
        break
    dep, row, col = q.popleft()

    if dep - 1 >= 0 and l1[dep - 1][row][col] == 0:
        l1[dep - 1][row][col] = l1[dep][row][col] + 1
        q.append([dep - 1, row, col])
    if dep + 1 <= l - 1 and l1[dep + 1][row][col] == 0:
        l1[dep + 1][row][col] = l1[dep][row][col] + 1
        q.append([dep + 1, row, col])
    if row - 1 >= 0 and l1[dep][row - 1][col] == 0:
        l1[dep][row - 1][col] = l1[dep][row][col] + 1
        q.append([dep, row - 1, col])
    if row + 1 <= n - 1 and l1[dep][row + 1][col] == 0:
        l1[dep][row + 1][col] = l1[dep][row][col] + 1
        q.append([dep, row + 1, col])
    if col - 1 >= 0 and l1[dep][row][col - 1] == 0:
        l1[dep][row][col - 1] = l1[dep][row][col] + 1
        q.append([dep, row, col - 1])
    if col + 1 <= m - 1 and l1[dep][row][col + 1] == 0:
        l1[dep][row][col + 1] = l1[dep][row][col] + 1
        q.append([dep, row, col + 1])
ans = 0
for i in range(l):
    for j in range(n):
        for k in range(m):
            if l1[i][j][k] == 0:
                print(-1)
                exit(0)
            ans = max(ans, l1[i][j][k])

print(ans-1)

