import sys
input = sys.stdin.readline

n, s = map(int, input().split())
nums = list(map(int, input().split()))
left = 0
right = 1
subTotal = nums[0]
inf = int(1e9)
subTotalLength = inf

while left < right:
    if subTotal >= s:
        subTotalLength = min(subTotalLength, right-left)
        subTotal -= nums[left]
        left += 1
        continue

    if subTotal < s:
        if right >= n:
            break
        subTotal += nums[right]
        right += 1

if subTotalLength == inf:
    print(0)
else:
    print(subTotalLength)
