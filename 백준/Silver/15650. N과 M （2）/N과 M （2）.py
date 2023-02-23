import sys
from itertools import combinations
input = sys.stdin.readline

n, m = map(int, input().split())
l1 = [i for i in range(1, n+1)]
for i in combinations(l1, m):
    print(*i)