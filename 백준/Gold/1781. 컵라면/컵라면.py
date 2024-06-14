import sys
from heapq import heappush, heappop
input = sys.stdin.readline

n = int(input())
l1 = []
for _ in range(n):
    l1.append(tuple(map(int, input().split())))

l1.sort(key=lambda x : (x[0], x[1]))

hq = []
result = [0] * (l1[-1][0]+1)

for i in range(len(result)-1, 0, -1):
    for j in range(len(l1)-1, -1, -1):
        if l1[-1][0] >= i:
            heappush(hq, (-l1[-1][1], l1[-1][0]))
            l1.pop()
        else:
            break
    if hq:
        result[i] = heappop(hq)[0]

print(-sum(result))