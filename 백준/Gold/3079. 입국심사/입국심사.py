import sys
input = sys.stdin.readline


n, m = map(int, input().split())
T = []

for _ in range(n):
    T.append(int(input()))

left = min(T)
right = max(T) * m
answer = 1e20

while left <= right:
    mid = (left+right) // 2

    total = 0
    for t in T:
        total += mid // t

    if total >= m:
        answer = min(answer, mid)
        right = mid - 1
    else:
        left = mid + 1

print(answer)