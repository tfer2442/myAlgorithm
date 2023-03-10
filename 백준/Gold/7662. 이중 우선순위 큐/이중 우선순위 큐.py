# heapq, deque 사용법

import sys
#from collections import deque
import heapq

input = sys.stdin.readline

t = int(input())

for _ in range(t):
    k = int(input())
    visited = [False] * k

    minh = []
    maxh = []

    for j in range(k):
        tmp1, tmp2 = input().split()
        tmp2 = int(tmp2)
        if tmp1 == 'I':
            heapq.heappush(minh, (tmp2, j))
            heapq.heappush(maxh, (-tmp2, j))
        else:
            if tmp2 == 1:
                for _ in range(len(maxh)):
                    if visited[maxh[0][1]]:
                        heapq.heappop(maxh)
                    else:
                        visited[maxh[0][1]] = True
                        heapq.heappop(maxh)
                        break

            else:
                for _ in range(len(minh)):
                    if visited[minh[0][1]]:
                        heapq.heappop(minh)
                    else:
                        visited[minh[0][1]] = True
                        heapq.heappop(minh)
                        break

    for a in minh:
        if visited[minh[0][1]]:
            heapq.heappop(minh)
        else:
            break
    for a in maxh:
        if visited[maxh[0][1]]:
            heapq.heappop(maxh)
        else:
            break

    if len(minh) == 0 or len(maxh) == 0:
        print('EMPTY')
    else:
        print(-maxh[0][0], minh[0][0])
