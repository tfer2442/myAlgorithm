import sys
input = sys.stdin.readline
from heapq import heappush, heappop

n = int(input())
l1 = []
l2 = []

for i in range(n):
    a, b = map(int, input().split())
    l1.append((a, b))

l1.sort()
heappush(l2, l1[0][1])

for i in range(1, n):
    if l1[i][0] < l2[0]:
        heappush(l2, l1[i][1])
    else:
        heappop(l2)
        heappush(l2, l1[i][1])
print(len(l2))
