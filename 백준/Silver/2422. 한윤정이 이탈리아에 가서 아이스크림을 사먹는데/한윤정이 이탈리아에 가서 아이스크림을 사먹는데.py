import sys
from itertools import combinations

input = sys.stdin.readline

n, m = map(int, input().split())
iceCombies = {}

for _ in range(m):
    iceCombies[tuple(map(int, input().split()))] = 1

cnt = 0
for a, b, c in combinations(range(1, n+1), 3):
    if (a, b) in iceCombies or (b, c) in iceCombies or (a, c) in iceCombies:
        continue
    if (b, a) in iceCombies or (c, b) in iceCombies or (c, a) in iceCombies:
        continue
    cnt += 1

print(cnt)
