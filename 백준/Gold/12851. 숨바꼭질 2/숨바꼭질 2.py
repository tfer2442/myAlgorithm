import sys
from collections import deque
input = sys.stdin.readline


def bfs():
    while l1:
        tmp = l1.popleft()

        for i in [tmp - 1, tmp + 1, tmp * 2]:
            if 0 <= i <= 100000:
                if visited[i][0] == 0:
                    visited[i][0] = visited[tmp][0] + 1
                    visited[i][1] = visited[tmp][1]
                    l1.append(i)
                elif visited[i][0] == visited[tmp][0] + 1:
                    visited[i][1] += visited[tmp][1]


n, k = map(int, input().split())
l1 = deque()
visited = [[0, 0] for _ in range(100001)]
l1.append(n)
visited[n][0] = 1
visited[n][1] = 1

if n >= k:
    print(n-k)
    print(1)
else:
    bfs()
    print(visited[k][0] - 1)
    print(visited[k][1])
