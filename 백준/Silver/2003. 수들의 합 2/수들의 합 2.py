import sys
input = sys.stdin.readline

n, m = map(int, input().split())
nums = list(map(int, input().split()))

left = 0
right = 1
subTotal = nums[0]
cnt = 0

while left <= right:
    if left >= n:
        break

    if subTotal == m:
        cnt += 1
        if right >= n:
            break
        subTotal -= nums[left]
        subTotal += nums[right]
        left += 1
        right += 1
        continue

    if subTotal > m:
        subTotal -= nums[left]
        left += 1
        continue

    if subTotal < m:
        if right >= n:
            break
        subTotal += nums[right]
        right += 1
        continue

print(cnt)