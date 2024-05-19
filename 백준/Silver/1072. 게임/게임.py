import sys
input = sys.stdin.readline

x, y = map(int, input().split())
winRate = y*100//x

if x == y or winRate == 99:
    print(-1)
    exit(0)

left = 0
right = 1_000_000_000_000_000_000_000_000
answer = 1_000_000_000_000_000_000_000_000

while left <= right:
    mid = (left + right) // 2
    curRate = (y+mid) * 100 // (x+mid) 

    if curRate > winRate:
        answer = min(answer, mid)
        right = mid - 1
    else:
        left = mid + 1

if answer == 1_000_000_000_000_000_000_000_000:
    print(-1)
else:
    print(answer)