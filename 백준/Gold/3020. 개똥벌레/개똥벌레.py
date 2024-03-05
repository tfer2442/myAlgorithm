import sys
input = sys.stdin.readline

n, h = map(int, input().split())
upStone = [0] * h
downStone = [0] * h
upSum = 0
downSum = 0

for i in range(n):
    stone = int(input())

    if i == 0 or i % 2 == 0:
        downStone[stone] += 1
        downSum += 1
    else:
        upStone[stone] += 1
        upSum += 1

downPass = [0] * (h+1)
downPass[1] = downSum
for i in range(2, h+1):
    downSum -= downStone[i-1]

    if downSum < 0:
        break
    downPass[i] = downSum

upPass = [0] * (h+1)
upPass[h] = upSum
for i in range(h-1, 0, -1):
    upSum -= upStone[h-i]

    if upSum < 0:
        break
    upPass[i] = upSum

minValue = int(1e9)
for i in range(1, h+1):
    minValue = min(minValue, upPass[i] + downPass[i])
cnt = 0

for i in range(1, h+1):
    if upPass[i] + downPass[i] == minValue:
        cnt += 1
print(minValue, cnt)
