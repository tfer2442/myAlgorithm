import sys
from itertools import permutations
input = sys.stdin.readline

n = int(input())

l1 = list(range(1, n+1))

for i in permutations(l1):
    print(*i)
