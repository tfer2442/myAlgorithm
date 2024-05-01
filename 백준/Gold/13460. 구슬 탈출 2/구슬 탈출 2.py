import sys
from collections import deque
input = sys.stdin.readline


def move(position, direction):
    curRow = position[0]
    curCol = position[1]

    for _ in range(10):
        if board[curRow + direction[0]][curCol] == 'O':
            curRow += direction[0]
            break
        elif board[curRow + direction[0]][curCol] != '#':
            curRow += direction[0]

        if board[curRow][curCol + direction[1]] == 'O':
            curCol += direction[1]
            break
        elif board[curRow][curCol + direction[1]] != '#':
            curCol += direction[1]

        if board[curRow + direction[0]][curCol + direction[1]] == '#':
            break

    return [curRow, curCol]


def order(curR, curB, curD):
    r = move(curR, curD)
    b = move(curB, curD)

    if b == r:
        if hole == tuple(b):
            return tuple(curR), tuple(curB)

    if curD[0] == 0 and curD[1] == 1:
        if b == r:
            if curR[1] < curB[1]:
                r[1] -= 1
            else:
                b[1] -= 1
    elif curD[0] == 0 and curD[1] == -1:
        if b == r:
            if curR[1] < curB[1]:
                b[1] += 1
            else:
                r[1] += 1
    elif curD[0] == 1 and curD[1] == 0:
        if b == r:
            if curR[0] < curB[0]:
                r[0] -= 1
            else:
                b[0] -= 1
    elif curD[0] == -1 and curD[1] == 0:
        if b == r:
            if curR[0] < curB[0]:
                b[0] += 1
            else:
                r[0] += 1

    return tuple(r), tuple(b)



n, m = map(int, input().split())
board = []

for _ in range(n):
    board.append(input().strip())

for i in range(n):
    for j in range(m):
        if board[i][j] == 'R':
            red = (i, j)
        elif board[i][j] == 'B':
            blue = (i, j)
        elif board[i][j] == 'O':
            hole = (i, j)


d = [(-1, 0), (0, -1), (1, 0), (0, 1)]
q = deque()
q.append((red, blue, 0))
visited = {}

while q:
    curRed, curBlue, cnt = q.popleft()

    if cnt > 10:
        print(-1)
        break

    if curBlue == hole:
        continue

    if curRed == hole:
        print(cnt)
        break

    for curD in d:
        if (curRed, curBlue, curD) not in visited:
            visited[(curRed, curBlue, curD)] = True
            red, blue = order(curRed, curBlue, curD)
            q.append((red, blue, cnt+1))
else:
    print(-1)