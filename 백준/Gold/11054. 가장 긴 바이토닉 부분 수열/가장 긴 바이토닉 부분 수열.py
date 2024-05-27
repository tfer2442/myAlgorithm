import sys
input = sys.stdin.readline

n = int(input())
nums = [0] + list(map(int, input().split())) + [0]
dp1 = [0] * (n+2)
dp2 = [0] * (n+2)

for i in range(1, n+1):
    maxValue = 0
    for j in range(i, -1, -1):
        if nums[i] > nums[j]:
            maxValue = max(maxValue, dp1[j])
    dp1[i] = maxValue + 1

for i in range(n, 0, -1):
    maxValue = 0
    for j in range(i, n+2):
        if nums[i] > nums[j]:
            maxValue = max(maxValue, dp2[j])
    dp2[i] = maxValue + 1


maxLen = 0
for i in range(n+1):
    maxValue = 0
    for j in range(i+1, n+2):
        if nums[i] != nums[j]:
            maxValue = max(maxValue, dp2[j])

    maxLen = max(maxLen, dp1[i] + maxValue)

print(maxLen)