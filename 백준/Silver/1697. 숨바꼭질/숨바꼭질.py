import sys
from collections import deque
input = sys.stdin.readline

n, k = map(int, input().split())

l1 = deque()
visited = [0]*100001
l1.append(n)
visited[n] = 1

while True:
    if visited[k]:
        print(visited[k] - 1)
        break
    tmp = l1.popleft()

    cal = []
    if tmp-1 >= 0:
        cal.append(tmp-1)
    if tmp+1 <= 100000:
        cal.append(tmp+1)
    if tmp*2 <= 100000:
        cal.append(tmp*2)

    for i in cal:
        if not visited[i]:
            l1.append(i)
            visited[i] = visited[tmp] + 1
