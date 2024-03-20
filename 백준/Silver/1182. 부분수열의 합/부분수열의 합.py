import sys
from itertools import combinations
input = sys.stdin.readline

n, s = map(int, input().split())
nums = list(map(int, input().split()))
sums = list()

for i in range(1, n+1):
    for combi in combinations(nums, i):
        sums.append(sum(combi))

print(sums.count(s))
