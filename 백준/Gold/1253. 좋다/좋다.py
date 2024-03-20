import sys
from itertools import combinations
input = sys.stdin.readline

n = int(input())
l1 = list(map(int, input().split()))
for i in range(n):
    l1[i] = (l1[i], i)

sumDict = {}

for a, b in combinations(l1, 2):
    if a[0]+b[0] not in sumDict:
        sumDict[a[0]+b[0]] = []
    sumDict[a[0]+b[0]].append((a[1], b[1]))

cnt = 0
for num, i in l1:
    if num not in sumDict:
        continue
    for a, b in sumDict[num]:
        if a == i or b == i:
            continue
        break
    else:
        continue
    cnt += 1

print(cnt)