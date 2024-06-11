import sys
from heapq import heappush, heappop
input = sys.stdin.readline

N, K = map(int, input().split())
jewelry = []
bags = []

for _ in range(N):
    m, v = map(int, input().split())
    jewelry.append((m, v))

for _ in range(K):
    bags.append(int(input()))

jewelry.sort(key=lambda x: (x[0], x[1]))
bags.sort()
hq = []
left = 0
result = 0

for bag in bags:
    while left < N and jewelry[left][0] <= bag:
        heappush(hq, -jewelry[left][1])
        left += 1
    if not hq:
        continue
    result += -heappop(hq)

print(result)
