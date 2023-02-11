import sys
input = sys.stdin.readline
import heapq

n = int(input())
l2 = []

l1 = list(map(int, input().split()))
for j in range(n):
    heapq.heappush(l2, l1[j])


for i in range(1, n):
    l1 = list(map(int, input().split()))
    for j in range(n):
        if l2[0] < l1[j]:
            heapq.heappushpop(l2, l1[j])

print(l2[0])
