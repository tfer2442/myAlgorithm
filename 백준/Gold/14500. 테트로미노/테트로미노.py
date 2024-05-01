import sys
from collections import deque

input = sys.stdin.readline


def mountain(startRow, startCol):
    for a, b, c in mountainBlock:
        row1, row2, row3 = startRow + a[0], startRow + b[0], startRow + c[0]
        col1, col2, col3 = startCol + a[1], startCol + b[1], startCol + c[1]

        if 0 <= row1 < n and 0 <= row2 < n and 0 <= row3 < n:
            if 0 <= col1 < m and 0 <= col2 < m and 0 <= col3 < m:
                totales.append(board[startRow][startCol] + board[row1][col1] + board[row2][col2] + board[row3][col3])


def bfs(startRow, startCol):
    q = deque()
    q.append(((startRow, startCol), [(startRow, startCol)], 1))
    visited = {}

    while q:
        curNode, memory, cnt = q.popleft()
        curRow, curCol = curNode

        if cnt == 4:
            total = 0
            for row, col in memory:
                total += board[row][col]
            totales.append(total)
            continue

        if tuple(memory) in visited:
            continue

        visited[tuple(memory)] = True

        for curD in d:
            nextRow = curRow+curD[0]
            nextCol = curCol+curD[1]

            if 0 <= nextRow < n and 0 <= nextCol < m:
                tmpMemory = memory[:]
                if (nextRow, nextCol) not in tmpMemory:
                    tmpMemory.append((nextRow, nextCol))
                    q.append(((nextRow, nextCol), tmpMemory, cnt+1))


n, m = map(int, input().split())
board = []
totales = []
d = [(0, 1), (0, -1), (1, 0), (-1, 0)]

mountainBlock = [((0, 1), (0, 2), (-1, 1)), ((0, 1), (0, 2), (1, 1)),
                 ((1, 0), (2, 0), (1, 1)), ((1, 0), (2, 0), (1, -1)),
                 ((0, -1), (0, -2), (1, -1)), ((0, -1), (0, -2), (-1, -1)),
                 ((-1, 0), (-2, 0), (-1, -1)), ((-1, 0), (-2, 0), (-1, 1))]

for _ in range(n):
    board.append(list(map(int, input().split())))


for i in range(n):
    for j in range(m):
        bfs(i, j)


for i in range(n):
    for j in range(m):
        mountain(i, j)

print(max(totales))