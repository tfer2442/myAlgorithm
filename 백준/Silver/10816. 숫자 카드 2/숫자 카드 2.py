import sys
from bisect import bisect_left, bisect_right
input = sys.stdin.readline

n = int(input())
cards = list(map(int, input().split()))
cards.sort()
m = int(input())
nums = list(map(int, input().split()))

for num in nums:
    left = bisect_left(cards, num)
    if left >= n or cards[left] != num:
        print(0, end=' ')
        continue

    right = bisect_right(cards, num)
    print(right-left, end=' ')
