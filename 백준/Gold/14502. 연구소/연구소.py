import sys
from collections import deque
from itertools import combinations
from copy import deepcopy
input = sys.stdin.readline

n, m = map(int, input().split())
board = list()

for _ in range(n):
    board.append(list(map(int, input().split())))


virus = []
d = [(0, 1), (1, 0), (-1, 0), (0, -1)]
for i in range(n):
    for j in range(m):
        if board[i][j] == 2:
            virus.append((i, j))

answer = 0
for combi in combinations(range(n*m), 3):
    a, b, c = combi
    a = (a // m, a % m)
    b = (b // m, b % m)
    c = (c // m, c % m)
    board2 = deepcopy(board)


    def bfs():
        global answer

        q = deque()

        for v in virus:
            q.append(v)

        while q:
            curRow, curCol = q.popleft()

            # if board2[curRow][curCol] == 2:
            #     continue

            for dRow, dCol in d:
                nextRow, nextCol = curRow + dRow, curCol + dCol

                if 0 <= nextRow < n and 0 <= nextCol < m and board2[nextRow][nextCol] == 0:
                    board2[nextRow][nextCol] = 2
                    q.append((nextRow, nextCol))

        cnt = 0
        for i in range(n):
            for j in range(m):
                if board2[i][j] == 0:
                    cnt += 1
        answer = max(answer, cnt)


    if a in virus or b in virus or c in virus:
        continue
    if board2[a[0]][a[1]] == 1 or board2[b[0]][b[1]] == 1 or board2[c[0]][c[1]] == 1:
        continue
    board2[a[0]][a[1]] = 1
    board2[b[0]][b[1]] = 1
    board2[c[0]][c[1]] = 1
    bfs()


print(answer)