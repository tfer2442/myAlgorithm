import sys
input = sys.stdin.readline

board = []

for i in range(9):
    board.append(list(map(int, input().split())))

empty = []
for i in range(9):
    for j in range(9):
        if board[i][j] == 0:
            empty.append((i, j))

# 가로
def check1(row, value):
    for i in range(9):
        if board[row][i] == value:
            return False
    return True


def check2(col, value):
    for i in range(9):
        if board[i][col] == value:
            return False
    return True


def check3(row, col, value):
    for i in range(row//3 * 3, row//3 * 3 + 3):
        for j in range(col//3 * 3, col//3 * 3 +3):
            if board[i][j] == value:
                return False
    return True


def dfs(cnt):
    if cnt == len(empty):
        for i in range(9):
            print(*board[i])
        exit(0)

    row, col = empty[cnt]

    for i in range(1, 10):
        if check1(row, i) and check2(col, i) and check3(row, col, i):
            board[row][col] = i
            dfs(cnt+1)
            board[row][col] = 0

cnt = 0
dfs(0)