import sys
from collections import Counter
input = sys.stdin.readline

n = int(input())
d = []

for _ in range(n):
    d.append(Counter(input().strip()))

visit = [False] * n
cnt = 0

for i in range(n):
    if visit[i]:
        continue
    visit[i] = True
    cnt += 1

    for j in range(i+1, n):
        if d[i] == d[j]:
            visit[j] = True
print(cnt)
