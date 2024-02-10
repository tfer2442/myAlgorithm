import sys
input = sys.stdin.readline

n = int(input())

cnt = 1
d = 0
maxValue = 1

while True:
    if n <= maxValue:
        print(cnt)
        break
    cnt += 1
    d += 6
    maxValue += d
