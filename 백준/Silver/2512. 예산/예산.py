import sys
input = sys.stdin.readline


def midsum(mid):
    suml1 = 0
    for i in range(n):
        if mid >= l1[i]:
            suml1 += l1[i]
        else:
            suml1 += mid
    return suml1



n = int(input())
l1 = list(map(int, input().split()))
m = int(input())

left = 0
right = max(l1)
cnt = 0
result = left
while True:
    if left > right:
        break
    mid = (left + right) // 2
    target = midsum(mid)
    if target == m:
        result = mid
        break
    elif target < m:
        result = mid
        left = mid + 1
    else:
        right = mid - 1

print(result)