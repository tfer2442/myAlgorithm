import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**7)
import heapq

n = int(input())
l1 = []

for _ in range(n):
    tmp = int(input())

    if tmp == 0:
        if l1:
            print(heapq.heappop(l1))
        else:
            print(0)
    else:
        heapq.heappush(l1, tmp)