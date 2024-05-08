#  21:15

import sys

sys.setrecursionlimit(10**7)
input = sys.stdin.readline


def backtracking(curRow, curCol):
    if curRow == n-1 and curCol == m-1:
        return 1

    if dp[curRow][curCol] == -1:
        dp[curRow][curCol] = 0

        for r, c in d:
            nextRow, nextCol = curRow + r, curCol + c

            if 0 <= nextRow < n and 0 <= nextCol < m and board[curRow][curCol] > board[nextRow][nextCol]:
                dp[curRow][curCol] += backtracking(nextRow, nextCol)

    return dp[curRow][curCol]


n, m = map(int, input().split())
board = []

for i in range(n):
    board.append(list(map(int, input().split())))

d = [[0, 1], [1, 0], [0, -1], [-1, 0]]
dp = [[-1]*m for _ in range(n)]

print(backtracking(0, 0))
