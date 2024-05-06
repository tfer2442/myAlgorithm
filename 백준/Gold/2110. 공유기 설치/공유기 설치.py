import sys
input = sys.stdin.readline

def countHouse(mid):
    cnt = 1
    start = 0
    for i in range(1, n):
        if house[i] - house[start] >= mid:
            start = i
            cnt += 1
    return cnt


n, m = map(int, input().split())
house = []

for _ in range(n):
    house.append(int(input()))

house.sort()
left = 0
right = max(house)
answer = -1

while left <= right:
    mid = (left + right) // 2
    value = countHouse(mid)
    if value < m:
        right = mid - 1
    elif value >= m:
        left = mid + 1
        answer = max(answer, mid)

print(answer)