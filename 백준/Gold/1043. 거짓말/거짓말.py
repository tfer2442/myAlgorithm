import sys
import copy
from itertools import combinations
input = sys.stdin.readline


def dfs(cnt):
    for i in graph[cnt]:
        if not visited[i]:
            visited[i] += 1
            dfs(i)


n, m = map(int, input().split())
tmp = list(map(int, input().split()))
graph = [[] for _ in range(n+1)]
visited = [0] * (n+1)
l1 = list()  # 진실을 아는 자
t = tmp[0]

if not tmp[0]:
    print(m)
    exit(0)

for i in range(1, t+1):
    l1.append(tmp[i])
l3 = list()  # 몇 번째 파티에 진실을 아는 자가 있는지 알기 위한 리스트
l4 = list()  # 파티의 대한 모든 정보
for i in range(m):
    l2 = list(map(int, input().split()))
    l4.append(l2[1:])

    if l2[0] == 1:
        if l2[1] in l1:
            l3.append(i)
        continue
    #l4.append(copy.deepcopy(l2[1:]))
    for j in combinations(l2[1:], 2):
        if j[0] in l1 or j[1] in l1:
            l3.append(i)

        graph[j[0]].append(j[1])
        graph[j[1]].append(j[0])

for i in l3:
    for j in l4[i]:
        if not visited[j]:
            visited[j] += 1
            dfs(j)

result = 0
for i in l4:
    for j in i:
        if visited[j]:
           break
    else:
        result += 1
print(result)