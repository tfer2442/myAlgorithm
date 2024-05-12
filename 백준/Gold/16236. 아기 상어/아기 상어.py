import sys
from collections import deque
input = sys.stdin.readline


n = int(input())
board = []

for _ in range(n):
    board.append(list(map(int, input().split())))

shark = []
baby = []

for i in range(n):
    for j in range(n):
        if board[i][j] == 9:
            baby.append(i)
            baby.append(j)
            baby.append(2)
            baby.append(0)
        elif 1 <= board[i][j] <= 6:
            shark.append((i, j, board[i][j]))

d = [(1, 0), (0, 1), (-1, 0), (0, -1)]
answer = 0


def bfs():
    global answer
    visited = [[False] * n for _ in range(n)]
    q = deque()

    visited[baby[0]][baby[1]] = True
    q.append((baby[0], baby[1], baby[2], 0))
    board[baby[0]][baby[1]] = 0
    minDistance = 10000
    distance = []

    while q:
        curRow, curCol, curSize, cnt = q.popleft()

        if cnt > minDistance:
            break

        if cnt != 0 and curSize != 0:
            minDistance = min(minDistance, cnt)
            distance.append((curRow, curCol, curSize, cnt))

        for dr, dc in d:
            nextRow, nextCol = curRow + dr, curCol + dc

            if 0 <= nextRow < n and 0 <= nextCol < n and not visited[nextRow][nextCol] and board[nextRow][nextCol] < baby[2]:
                visited[nextRow][nextCol] = True
                q.append((nextRow, nextCol, board[nextRow][nextCol], cnt+1))
            elif 0 <= nextRow < n and 0 <= nextCol < n and not visited[nextRow][nextCol] and board[nextRow][nextCol] == baby[2]:
                visited[nextRow][nextCol] = True
                q.append((nextRow, nextCol, 0, cnt+1))

    if not distance:
        print(answer)
        exit(0)

    distance.sort(key=lambda x: (x[0], x[1]))
    baby[0], baby[1] = distance[0][0], distance[0][1]
    answer += distance[0][3]
    baby[3] += 1

    if baby[2] == baby[3]:
        baby[2] += 1
        baby[3] = 0


while True:
    bfs()