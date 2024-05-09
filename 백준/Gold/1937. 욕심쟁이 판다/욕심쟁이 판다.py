import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline


def dfs(r, c):
    for dr, dc in d:
        nextR, nextC = r + dr, c + dc

        if 0 <= nextR < n and 0 <= nextC < n and forest[r][c] < forest[nextR][nextC]:
            if dp[nextR][nextC] == -1:
                dp[r][c] = max(dp[r][c], dfs(nextR, nextC))
            else:
                dp[r][c] = max(dp[r][c], dp[nextR][nextC]+1)

    return dp[r][c]+1


n = int(input())
forest = []
for _ in range(n):
    forest.append(list(map(int, input().split())))

d = [(1, 0), (0, 1), (-1, 0), (0, -1)]
dp = [[-1] * n for _ in range(n)]

answer = -1
for i in range(n):
    for j in range(n):
        answer = max(answer, dfs(i, j))

print(answer+1)
