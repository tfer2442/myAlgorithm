import sys
input = sys.stdin.readline


def dfs(row, col, cnt):
    global answer

    answer = max(cnt, answer)

    if answer == r*c:
        return
    for dr, dc in d:
        nextRow, nextCol = row + dr, col + dc
        if 0 <= nextRow < r and 0 <= nextCol < c and not remember[ord(board[nextRow][nextCol])-65]:
            remember[ord(board[nextRow][nextCol])-65] = True
            dfs(nextRow, nextCol, cnt+1)
            remember[ord(board[nextRow][nextCol])-65] = False


r, c = map(int, input().split())
board = list()
d = [(1, 0), (0, 1), (-1, 0), (0, -1)]

for _ in range(r):
    board.append(input())

answer = -1
remember = [0] * 26
cnt = 1

remember[ord(board[0][0])-65] = True

dfs(0, 0, cnt)
print(answer)