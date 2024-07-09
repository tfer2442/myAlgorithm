from collections import deque

def count_bomb():
    for i in range(n):
        for j in range(n):
            if board[i][j] == '*':
                visited[i][j] = True
                continue
            bomb = 0

            for checkRow, checkCol in d:
                if 0 > i+checkRow or i+checkRow >= n or 0 > j+checkCol or j+checkCol >= n:
                    continue
                if board[i+checkRow][j+checkCol] == '*':
                    bomb += 1
            board[i][j] = bomb


def bfs(row, col):
    dq = deque()
    dq.append((row, col))

    while dq:
        curRow, curCol = dq.popleft()
        board[curRow][curCol] = -1

        for dRow, dCol in d:
            nextRow, nextCol = curRow + dRow, curCol + dCol

            if 0 > nextRow or nextRow >= n or 0 > nextCol or nextCol >= n:
                continue

            if not visited[nextRow][nextCol] and board[nextRow][nextCol] == 0:
                dq.append((nextRow, nextCol))
                visited[nextRow][nextCol] = True
            elif not visited[nextRow][nextCol] and board[nextRow][nextCol] != '*':
                visited[nextRow][nextCol] = True


T = int(input())
d = [(-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1)]

for t in range(1, T+1):
    n = int(input())
    board = []
    visited = [[False]*n for _ in range(n)]

    for _ in range(n):
        board.append(list(input().strip()))
    count_bomb()
    result = 0

    for i in range(n):
        for j in range(n):
            if board[i][j] == 0:
                result += 1
                visited[i][j] = True
                bfs(i, j)

    for i in range(n):
        for j in range(n):
            if not visited[i][j] and board[i][j] != '*':
                result += 1

    print('#%d' % t, result)
