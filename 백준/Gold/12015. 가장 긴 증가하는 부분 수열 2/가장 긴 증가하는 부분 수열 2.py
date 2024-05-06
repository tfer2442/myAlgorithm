import sys
from bisect import bisect_left
input = sys.stdin.readline

n = int(input())
nums = list(map(int, input().split()))

sequence = [nums[0]]

for i in range(1, n):
    insertIndex = bisect_left(sequence, nums[i])

    if insertIndex < len(sequence):
        sequence[insertIndex] = nums[i]
    else:
        sequence.append(nums[i])

print(len(sequence))
