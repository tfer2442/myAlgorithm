import sys
input = sys.stdin.readline

g = int(input())
p = int(input())
airplane = []

for _ in range(p):
    airplane.append(int(input()))

parent = list(range(g+1))


def findParent(v):
    if parent[v] == v:
        return v
    parent[v] = findParent(parent[v])
    return parent[v]


def union(x, y):
    parentX = findParent(x)
    parentY = findParent(y)

    parent[parentY] = parentX


cnt = 0
for i, num in enumerate(airplane):
    fp = findParent(num)
    if fp == 0:
        break
    union(fp-1, fp)
    cnt += 1
print(cnt)
