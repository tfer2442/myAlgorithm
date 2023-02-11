import sys
from heapq import heappush, heappushpop
input = sys.stdin.readline

n = int(input())
l1 = []

for j in list(map(int, input().split())):
    heappush(l1, j)
for i in range(1, n):
    for j in list(map(int, input().split())):
        if l1[0] < j:
            heappushpop(l1, j)
print(l1[0])