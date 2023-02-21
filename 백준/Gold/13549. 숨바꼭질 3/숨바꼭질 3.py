import sys
from collections import deque
input = sys.stdin.readline


def bfs():
    if n >= k:
        print(n - k)
        return
    else:
        while True:
            if visited[k]:
                print(visited[k] - 1)
                return
            tmp = l1.popleft()

            for i in [tmp * 2, tmp-1, tmp+1]:
                if 0 <= i <= 100000 and not visited[i]:
                    l1.append(i)
                    if i != tmp * 2:
                        visited[i] = visited[tmp] + 1
                    else:
                        visited[i] = visited[tmp]


n, k = map(int, input().split())

l1 = deque()
visited = [0]*100001
l1.append(n)
visited[n] = 1
bfs()
