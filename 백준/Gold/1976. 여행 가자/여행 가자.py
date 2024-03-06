import sys
input = sys.stdin.readline


def findParent(num):
    if parent[num] == num:
        return num

    parent[num] = findParent(parent[num])
    return parent[num]


def unionNode(a, b):
    parentA = findParent(a)
    parentB = findParent(b)

    if parentA < parentB:
        parent[parentB] = parentA
        return

    if parentB < parentA:
        parent[parentA] = parentB
        return


n = int(input())
m = int(input())
parent = list(range(n+1))

for i in range(1, n+1):
    connectionInfo = list(map(int, input().split()))
    for j, num in enumerate(connectionInfo):
        if num:
            unionNode(i, j+1)

plan = list(map(int, input().split()))
setParent = findParent(plan[0])
for i in range(1, m):
    if setParent != findParent(plan[i]):
        print('NO')
        break
else:
    print('YES')
