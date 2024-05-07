import sys
input = sys.stdin.readline


def countStone(mid):
    start = 0
    cnt = 0

    for i in range(n+1):
        if i == n:
            if stones[i] - start < mid:
                return -1
            else:
                return cnt
        if stones[i] - start >= mid:
            cnt += 1
            start = stones[i]


d, n, m = map(int, input().split())
stones = []

for _ in range(n):
    stones.append(int(input()))

stones.sort()
stones.append(d)
left = 0
right = d
answer = -1

while left <= right:
    mid = (left + right) // 2

    stoneCnt = countStone(mid)
    if stoneCnt >= n-m:
        answer = max(answer, mid)
        left = mid + 1
    elif stoneCnt < n-m:
        right = mid - 1

print(answer)