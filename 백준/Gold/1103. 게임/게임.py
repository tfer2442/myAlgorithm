import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline


def dfs(row, col):
    if dp[row][col] == -1:
        dp[row][col] = 0


    value = int(board[row][col])

    for dr, dc in d:
        nextR, nextC = dr * value + row, dc * value + col

        if 0 <= nextR < n and 0 <= nextC < m and board[nextR][nextC] != 'H':
            if visited[nextR][nextC] == True:
                print(-1)
                exit(0)
            if dp[nextR][nextC] == -1:
                visited[nextR][nextC] = True
                dp[row][col] = max(dp[row][col], dfs(nextR, nextC))
                visited[nextR][nextC] = False
            else:
                dp[row][col] = max(dp[row][col], dp[nextR][nextC]+1)


    return dp[row][col] + 1


n, m = map(int, input().split())
dp = [[-1] * m for _ in range(n)]
board = []
visited = [[False] * m for _ in range(n)]
d = [[-1, 0], [0, -1], [1, 0], [0, 1]]

for i in range(n):
    board.append(list(input().strip()))

visited[0][0] = True
answer = dfs(0, 0)
print(answer)