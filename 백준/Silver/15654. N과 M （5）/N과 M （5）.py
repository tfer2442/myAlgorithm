import sys
from itertools import permutations
input = sys.stdin.readline

n, m = map(int, input().split())
l1 = list(map(int, input().split()))
l1.sort()
for i in permutations(l1, m):
    print(*i)