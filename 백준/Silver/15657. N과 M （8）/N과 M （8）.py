import sys
from itertools import combinations_with_replacement
input = sys.stdin.readline

n, m = map(int, input().split())
l1 = list(map(int, input().split()))
l1.sort()
for i in combinations_with_replacement(l1, m):
    print(*i)