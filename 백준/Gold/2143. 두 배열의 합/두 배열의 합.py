import sys
from collections import Counter
input = sys.stdin.readline

t = int(input())
n = int(input())
a = list(map(int, input().split()))
m = int(input())
b = list(map(int, input().split()))
aSumList = list()
bSumList = list()

for i in range(n):
    aSum = 0
    for j in range(i, n):
        aSum += a[j]
        aSumList.append(aSum)

aSumList = Counter(aSumList)

for i in range(m):
    bSum = 0
    for j in range(i, m):
        bSum += b[j]
        bSumList.append(bSum)

bSumList = Counter(bSumList)
cnt = 0
for k in aSumList:
    if t - k in bSumList:
        cnt += aSumList[k] * bSumList[t-k]

print(cnt)
