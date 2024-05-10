import sys
input = sys.stdin.readline


n, m = map(int, input().split())
maze = []
visited = [[False] * m for _ in range(n)]

for _ in range(n):
    maze.append(list(input().strip()))


def dfs(r, c):
    global cnt
    dr, dc = d[maze[r][c]]

    visited[r][c] = True
    team[(r, c)] = True
    nextR, nextC = r + dr, c + dc

    if visited[nextR][nextC]:
        if (nextR, nextC) not in team:
            cnt -= 1
    else:
        dfs(nextR, nextC)


cnt = 0
d = {'D': (1, 0), 'U': (-1, 0), 'L': (0, -1), 'R': (0, 1)}

for i in range(n):
    for j in range(m):
        if visited[i][j]:
            continue
        team = {}
        dfs(i, j)
        cnt += 1
print(cnt)