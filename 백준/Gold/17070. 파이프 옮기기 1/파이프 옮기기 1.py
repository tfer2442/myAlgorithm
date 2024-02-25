import sys
input = sys.stdin.readline


def isMovePipe(row, col, d):
    if row >= n or col >= n:
        return False
    if d == 3:
        if house[row-1][col] == 1 or house[row][col-1] == 1:
            return False
    if house[row][col] == 0:
        return True
    if house[row][col] == 1:
        return False


def dfs(end, d):
    global cnt

    if end[0] == n-1 and end[1] == n-1:
        cnt += 1
        return

    if d == 1:
        if isMovePipe(end[0], end[1]+1, 1):  # 가로
            dfs((end[0], end[1]+1), 1)
        if isMovePipe(end[0]+1, end[1]+1, 3):  # 대각선
            dfs((end[0]+1, end[1]+1), 3)
    elif d == 2:
        if isMovePipe(end[0]+1, end[1], 2):  # 세로
            dfs((end[0]+1, end[1]), 2)
        if isMovePipe(end[0]+1, end[1]+1, 3):  # 대각선
            dfs((end[0]+1, end[1]+1), 3)
    elif d == 3:
        if isMovePipe(end[0]+1, end[1], 2):  # 세로
            dfs((end[0]+1, end[1]), 2)
        if isMovePipe(end[0], end[1]+1, 1):  # 가로
            dfs((end[0], end[1]+1), 1)
        if isMovePipe(end[0]+1, end[1]+1, 3):  # 대각선
            dfs((end[0]+1, end[1]+1), 3)


n = int(input())
house = [list(map(int, input().split())) for _ in range(n)]
if house[n-1][n-1] == 1:
    print(0)
    exit(0)
start = (0, 1)
cnt = 0
dfs(start, 1)
print(cnt)

