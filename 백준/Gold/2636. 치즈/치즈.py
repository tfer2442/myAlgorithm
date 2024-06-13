from collections import deque

n, m = map(int, input().split())
board = []
outside = [[1]*m for _ in range(n)]
cheeze = {}

for _ in range(n):
    board.append(list(map(int, input().split())))

for i in range(n):
    for j in range(m):
        if board[i][j] == 1:
            cheeze[(i, j)] = True

d = [(1, 0), (0, 1), (-1, 0), (0, -1)]


def bfs(startNode):
    dq = deque()
    dq.append((startNode[0], startNode[1]))
    board[startNode[0]][startNode[1]] = 0
    outside[startNode[0]][startNode[1]] = 0

    while dq:
        row, col = dq.popleft()

        for dr, dc in d:
            nextRow, nextCol = row + dr, col + dc

            if nextRow >= n or nextRow < 0 or nextCol >= m or nextCol < 0:
                continue

            if board[nextRow][nextCol] == 0 and outside[nextRow][nextCol] == 1:
                dq.append((nextRow, nextCol))
                outside[nextRow][nextCol] = 0

bfs((0, 0))
total = 0
result = len(cheeze)
while cheeze:
    total += 1
    tmp = []
    for ch in cheeze:
        cnt = 0
        for dr, dc in d:
            nextR, nextC = dr + ch[0], dc + ch[1]

            if outside[nextR][nextC] == 0:
                cnt += 1
        if cnt >= 1:
            tmp.append(ch)

    for t in tmp:
        bfs(t)
    result = len(cheeze)
    for i in range(len(tmp)):
        del cheeze[tmp[i]]

print(total)
print(result)