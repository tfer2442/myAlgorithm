import sys
input = sys.stdin.readline

n, m = map(int, input().split())
nums = [int(input()) for _ in range(n)]

nums.sort()

right = 1
answer = sys.maxsize

for left in range(n-1):
    subValue = nums[right] - nums[left]
    while right < n and subValue < m:
        subValue = nums[right]-nums[left]
        right += 1

    if subValue >= m:
        answer = min(answer, subValue)
    right -= 1

print(answer)