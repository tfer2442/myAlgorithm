import sys
input = sys.stdin.readline


def countBluray(mid):
    cnt = 1
    sumLecture = 0
    for i in range(n):
        if lectures[i] > mid:
            return int(1e10)+1
        if sumLecture + lectures[i] <= mid:
            sumLecture += lectures[i]
        else:
            sumLecture = lectures[i]
            cnt += 1
    return cnt


n, m = map(int, input().split())
lectures = list(map(int, input().split()))

left = min(lectures)
right = sum(lectures)
answer = int(1e10)+1
while left <= right:
    mid = (left + right)//2

    bluray = countBluray(mid)

    if bluray > m:
        left = mid + 1
    elif bluray <= m:
        answer = min(answer, mid)
        right = mid - 1

print(answer)
