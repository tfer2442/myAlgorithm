import sys
from itertools import permutations

input = sys.stdin.readline

n = int(input())
nums = list(map(int, input().split()))

maxValue = -int(1e9)
for tmp in permutations(nums):
    total = 0
    for i in range(n-1):
        total += abs(tmp[i] - tmp[i+1])
    maxValue = max(maxValue, total)

print(maxValue)