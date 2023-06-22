import sys
from collections import deque

sys.setrecursionlimit(10**6)
input = sys.stdin.readline


def dfs(v, count1):
    global gsum
    visited[v] = True

    for i in g1[v]:
        if not visited[i]:
            dfs(i, count1+1)

    if len(g1[v]) == 1 and v != 1:
       gsum = gsum + count1


def bfs(v):
    global gsum

    q = deque()
    q.append(v)
    visited[v] += 1

    while q:
        tmp = q.popleft()
        flag = False
        for i in g1[tmp]:
            if visited[i] == 0:
                q.append(i)
                flag = True
                visited[i] = visited[tmp] + 1
        if not flag:
            gsum += visited[tmp] - 1


n = int(input())
g1 = [[] for i in range(n+1)]

for i in range(n-1):
    a, b = map(int, input().split())
    g1[a].append(b)
    g1[b].append(a)

global gsum
gsum = 0

visited = [0] * (n+1)
#dfs(1, 0)
bfs(1)

if gsum % 2 == 0:
    print("No")
else:
    print("Yes")
