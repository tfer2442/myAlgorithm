import sys
from collections import Counter
from itertools import combinations
input = sys.stdin.readline

n, s = map(int, input().split())
nums = list(map(int, input().split()))
nums1 = nums[:n//2]
nums2 = nums[n//2:]
sums1 = Counter()
sums2 = Counter()
cnt = 0

for i in range(1, len(nums1)+1):
    for combi in combinations(nums1, i):
        scombi = sum(combi)
        sums1[scombi] += 1

for i in range(1, len(nums2)+1):
    for combi in combinations(nums2, i):
        scombi = sum(combi)
        sums2[scombi] += 1

for num in sums1:
    if s-num in sums2:
        cnt += sums2[s-num] * sums1[num]

cnt += sums1[s] + sums2[s]
print(cnt)

