import sys
from collections import deque
input = sys.stdin.readline


def findStart():
    for i in range(n):
        for j in range(m):
            if mapInfo[i][j] == 2:
                return i, j


n, m = map(int, input().split())
mapInfo = list()

for _ in range(n):
    mapInfo.append(list(map(int, input().split())))

start = findStart()
q = deque({start})

d = [[1, 0], [0, 1], [-1, 0], [0, -1]]

while q:
    y, x = q.popleft()

    for a, b in d:
        r, c = y + a, x + b

        if 0 <= r < n and 0 <= c < m and mapInfo[r][c] == 1:
            mapInfo[r][c] = mapInfo[y][x] + 1
            q.append((r, c))

for i in range(n):
    for j in range(m):
        if mapInfo[i][j] == 0:
            print(mapInfo[i][j], end=' ')
        else:
            print(mapInfo[i][j]-2, end=' ')
    print()
