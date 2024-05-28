import sys
from copy import deepcopy
input = sys.stdin.readline

n = int(input())
board = []
for i in range(n):
    board.append(list(map(int, input().split())))

board2 = deepcopy(board)

for k in range(n):
    for i in range(n):
        for j in range(n):
            board2[i][j] = min(board2[i][j], board2[i][k] + board2[k][j])

for i in range(n):
    for j in range(n):
        if board[i][j] != board2[i][j]:
            print(-1)
            exit(0)

maxValue = int(1e11)
total = 0
for a in range(n):
    for b in range(a+1, n):
        board2 = deepcopy(board)
        board2[a][b] = maxValue
        board2[b][a] = maxValue

        for k in range(n):
            for i in range(n):
                for j in range(n):
                    board2[i][j] = min(board2[i][j], board2[i][k] + board2[k][j])

        if board[a][b] != board2[a][b]:
            total += board[a][b]

print(total)
