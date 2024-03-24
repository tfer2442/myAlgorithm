import sys
input = sys.stdin.readline

n = int(input())
nums = list(map(int, input().split()))
nums.sort()

left = 0
right = n-1
result = (abs(nums[left]+nums[right]), nums[left], nums[right])

while left < right:
    tmp = nums[left] + nums[right]
    if abs(tmp) < result[0]:
        result = (abs(tmp), nums[left], nums[right])

    if tmp == 0:
        print(nums[left], nums[right])
        break

    if tmp > 0:
        right -= 1
        continue

    if tmp < 0:
        left += 1
        continue
else:
    print(result[1], result[2])
