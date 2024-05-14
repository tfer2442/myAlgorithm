import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

m, n, k = map(int, input().split())
squares = []
board = [[0]*m for _ in range(n)]

for i in range(k):
    squares.append(map(int, input().split()))

for i in range(k):
    y1, x1, y2, x2 = squares[i]
    for j in range(x1, x2):
        for k in range(y1, y2):
            board[k][j] = 1

d = [(1, 0), (0, 1), (-1, 0), (0, -1)]


def dfs(r, c):
    global answer
    visited[r][c] = True
    answer += 1

    for dr, dc in d:
        nextRow, nextCol = r + dr, c + dc
        if 0 <= nextRow < n and 0 <= nextCol < m:
            if not visited[nextRow][nextCol] and board[nextRow][nextCol] == 0:
                board[nextRow][nextCol] = 1
                dfs(nextRow, nextCol)


result = []
visited = [[False]*m for _ in range(n)]
for i in range(n):
    for j in range(m):
        if not visited[i][j] and board[i][j] == 0:
            answer = 0
            dfs(i, j)
            result.append(answer)

print(len(result))
print(*sorted(result))
