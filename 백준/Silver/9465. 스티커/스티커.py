import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    n = int(input())
    sticker = [list(map(int, input().split())) for _ in range(2)]

    for i in range(1, n):
        for j in range(2):
            if i == 1:
                sticker[0][1] += sticker[1][0]
                sticker[1][1] += sticker[0][0]
                break
            if j == 0:
                sticker[j][i] += max(sticker[1][i-1], sticker[1][i-2])
                continue
            if j == 1:
                sticker[j][i] += max(sticker[0][i-1], sticker[0][i-2])
    print(max(sticker[0][n-1], sticker[1][n-1]))

