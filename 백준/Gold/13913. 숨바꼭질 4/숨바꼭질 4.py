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

            for i in [tmp - 1, tmp + 1, tmp * 2]:
                if 0 <= i <= 100000 and not visited[i]:
                    l1.append(i)
                    visited[i] = visited[tmp] + 1


n, k = map(int, input().split())

l1 = deque()
visited = [0]*100001
l1.append(n)
visited[n] = 1

bfs()
target = k
s = [target]

if n <= k:
    while True:
        if visited[target] == 1:
            break

        if target - 1 >= 0 and visited[target - 1] == visited[target] - 1:
            s.append(target - 1)
            target = target - 1
        elif target + 1 <= 100000 and visited[target + 1] == visited[target] - 1:
            s.append(target + 1)
            target = target + 1
        elif visited[target // 2] == visited[target] - 1:
            s.append(target // 2)
            target = target // 2
else:
    for i in range(k+1, n+1):
        s.append(i)
b = len(s)
for i in range(b):
    print(s.pop(), end=' ')
