import sys
sys.setrecursionlimit(10**7)
input = sys.stdin.readline


def findParent(num):
    if num == parent[num]:
        return num

    parent[num] = findParent(parent[num])
    return parent[num]


def unionNode(x, y):
    parentX = findParent(x)
    parentY = findParent(y)

    if parentX < parentY:
        parent[parentY] = parentX
        return
    if parentX > parentY:
        parent[parentX] = parentY
        return


n, m = map(int, input().split())
parent = list(range(0, n+1))

for i in range(m):
    choice, a, b = map(int, input().split())
    if choice == 1:
        if findParent(a) == findParent(b):
            print('YES')
        else:
            print('NO')
        continue

    if choice == 0:
        unionNode(a, b)
