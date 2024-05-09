import sys
from collections import deque
input = sys.stdin.readline


def bfs(r, c, people):
    q = deque()
    q.append((r, c))

    while q:
        curR, curC = q.popleft()

        for dr, dc in d:
            nextR, nextC = curR + dr, curC + dc
            if 0 <= nextR < n and 0 <= nextC < n and not visited[nextR][nextC] and people[r][c] == people[nextR][nextC]:
                visited[nextR][nextC] = True
                q.append((nextR, nextC))


n = int(input())
visionPeople = []
blindnessPeople = [['']*n for _ in range(n)]

for _ in range(n):
    visionPeople.append(list(input()))

for i in range(n):
    for j in range(n):
        if visionPeople[i][j] == 'R' or visionPeople[i][j] == 'G':
            blindnessPeople[i][j] = 'G'
        elif visionPeople[i][j] == 'B':
            blindnessPeople[i][j] = 'B'

d = [(1, 0), (0, 1), (-1, 0), (0, -1)]
visited = [[False] * n for _ in range(n)]
visionCnt = 0
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            visionCnt += 1
            bfs(i, j, visionPeople)

blindnessCnt = 0
visited = [[False] * n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            blindnessCnt += 1
            bfs(i, j, blindnessPeople)

print(visionCnt, blindnessCnt)
