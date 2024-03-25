import sys
input = sys.stdin.readline

n, m = map(int, input().split())
nums = list(map(int, input().split()))

left = 0
cnt = 0
subTotal = 0

for right in range(n):
    subTotal += nums[right]
    while subTotal > m and left <= right:
        subTotal -= nums[left]
        left += 1

    if subTotal == m:
        cnt += 1

print(cnt)
