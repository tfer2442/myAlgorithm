import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline


def dfs(r, c):
    if r == n-1 and c == m-1:
        return maze[r][c]

    for dr, dc in d:
        nextR, nextC = r + dr, c + dc

        if 0 <= nextR < n and 0 <= nextC < m:
            if dp[nextR][nextC] == -1:
                dp[r][c] = max(dp[r][c], dfs(nextR, nextC))
            else:
                dp[r][c] = max(dp[r][c], dp[nextR][nextC])
    dp[r][c] += maze[r][c]
    return dp[r][c]


n, m = map(int, input().split())
maze = []
d = [(1, 0), (0, 1), (1, 1)]

for _ in range(n):
    maze.append(list(map(int, input().split())))

dp = [[-1] * m for _ in range(n)]
dp[0][0] = maze[0][0]
print(dfs(0, 0))