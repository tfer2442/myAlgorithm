import sys
from copy import deepcopy
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
space = []

for _ in range(n):
    space.append(list(map(int, input().split())))

for i in range(n):
    for j in range(m):
        if space[i][j] == 1:
            space[i][j] = '상어'

d1 = [-1, -1, 0, 1, 1, 1, 0, -1]
d2 = [0, 1, 1, 1, 0, -1, -1, -1]

distance = [[0]*m for _ in range(n)]

for i in range(n):
    for j in range(m):
        if space[i][j] == '상어':
            continue
        visited = deepcopy(space)
        q = deque()
        q.append((i, j))
        visited[i][j] = 1
        flag = False
        while q:
            node = q.popleft()

            for k in range(8):
                c = node[0] + d1[k]
                r = node[1] + d2[k]
                if 0 <= c < n and 0 <= r < m:
                    if visited[c][r] == '상어':
                        distance[i][j] = visited[node[0]][node[1]]
                        flag = True
                        break
                    if not visited[c][r]:
                        visited[c][r] = visited[node[0]][node[1]] + 1
                        q.append((c, r))
            if flag:
                break
maxValue = 0
for i in range(n):
    for j in range(m):
        maxValue = max(maxValue, distance[i][j])
print(maxValue)
