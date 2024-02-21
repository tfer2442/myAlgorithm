import sys
from collections import deque
input = sys.stdin.readline


def solution():
    mapInfo = list()
    start = 0

    for i in range(n):
        mapInfo.append(list(map(int, input().split())))

        if start == 0:
            for j in range(m):
                if mapInfo[i][j] == 2:
                    start = (i, j)

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
                print(mapInfo[i][j] - 2, end=' ')
        print()


n, m = map(int, input().split())
solution()
