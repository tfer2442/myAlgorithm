import sys
from collections import Counter
input = sys.stdin.readline

n = int(input())
cards = Counter(map(int, input().split()))
m = int(input())
nums = list(map(int, input().split()))

for num in nums:
    if num in cards:
        print(1, end=' ')
    else:
        print(0, end=' ')
