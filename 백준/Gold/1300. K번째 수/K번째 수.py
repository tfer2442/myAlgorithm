import sys
input = sys.stdin.readline


def countMinValue(mid):
    cnt = 0
    for i in range(1, n+1):
        cnt += min(n, mid // i)
    return cnt


n = int(input())
k = int(input())

left = 1
right = k

answer = int(1e10)+1
while left <= right:
    mid = (left + right) // 2

    totalCnt = countMinValue(mid)
    if totalCnt < k:
        left = mid + 1
    elif totalCnt >= k:
        answer = min(answer, mid)
        right = mid - 1

print(answer)