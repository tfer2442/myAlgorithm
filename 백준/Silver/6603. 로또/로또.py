import sys
from itertools import combinations
input = sys.stdin.readline

while True:
    nums = list(map(int, input().split()))

    if nums[0] == 0:
        break

    for combi in combinations(nums[1:], 6):
        print(*combi)
    print()
