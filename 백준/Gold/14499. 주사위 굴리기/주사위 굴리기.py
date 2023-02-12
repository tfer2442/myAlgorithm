import sys
input = sys.stdin.readline

n, m, y, x, k = map(int, input().split())

dmap = [[0] * m for _ in range(n)]
dice = [[0] * 3 for _ in range(4)]

for i in range(n):
    tmp = list(map(int, input().split()))
    for j in range(m):
        dmap[i][j] = tmp[j]

coms = list(map(int, input().split()))

for c in coms:
    if c == 1:
        if x + 1 >= m:
            continue
        x = x + 1
        dice[1][2], dice[1][1] = dice[1][1], dice[1][2]
        dice[1][1], dice[1][0] = dice[1][0], dice[1][1]
        dice[1][0], dice[3][1] = dice[3][1], dice[1][0]
    elif c == 2:
        if x - 1 < 0:
            continue
        x = x - 1
        dice[1][0], dice[1][1] = dice[1][1], dice[1][0]
        dice[1][1], dice[1][2] = dice[1][2], dice[1][1]
        dice[1][2], dice[3][1] = dice[3][1], dice[1][2]
    elif c == 3:
        if y - 1 < 0:
            continue
        y = y - 1
        dice[0][1], dice[1][1] = dice[1][1], dice[0][1]
        dice[1][1], dice[2][1] = dice[2][1], dice[1][1]
        dice[2][1], dice[3][1] = dice[3][1], dice[2][1]

    elif c == 4:
        if y + 1 >= n:
            continue
        y = y + 1

        dice[0][1], dice[1][1] = dice[1][1], dice[0][1]
        dice[0][1], dice[2][1] = dice[2][1], dice[0][1]
        dice[0][1], dice[3][1] = dice[3][1], dice[0][1]

    if dmap[y][x] == 0:
        dmap[y][x] = dice[3][1]
    else:
        dice[3][1] = dmap[y][x]
        dmap[y][x] = 0
    print(dice[1][1])
