import sys
input = sys.stdin.readline

n = int(input())
nums = list(map(int, input().split()))
x = int(input())

nums.sort()

left = 0
right = n-1
cnt = 0

while left < right:
    tmp = nums[left] + nums[right]
    if x == tmp:
        right -= 1
        cnt += 1
        continue
    if x < tmp:
        right -= 1
        continue
    if x > tmp:
        left += 1

print(cnt)
