import sys
from itertools import permutations
input = sys.stdin.readline

n, m = map(int, input().split())
l1 = list(map(int, input().split()))
l2 = []
for i in permutations(l1, m):
    l2.append(i)

l2 = set(l2)
l2 = list(l2)
l2.sort()

for i in l2:
    print(*i)