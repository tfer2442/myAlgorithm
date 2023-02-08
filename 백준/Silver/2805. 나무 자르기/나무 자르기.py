import sys
input = sys.stdin.readline

n, m = map(int, input().split())
l1 = list((map(int, input().split())))

left = 0
right = max(l1)
mid = (left + right) // 2

while True:
    if left >= right:
        print(mid)
        break

    Tsum = 0
    for i in range(n):
        if l1[i] - mid >= 0:
            Tsum += l1[i] - mid
        if Tsum > m:
            break

    if Tsum < m:
        right = mid
        mid = (right+left) // 2

    elif Tsum > m:
        left = mid
        mid = (right+left) // 2
        if left == mid:
            print(mid)
            break
    else:
        print(mid)
        break

