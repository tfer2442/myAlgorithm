import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**7)


def find(x):
    if x == parent[x]:
        return x

    y = find(parent[x])
    parent[x] = y
    return y


def union(a, b):
    a = find(a)
    b = find(b)

    if a != b:
        parent[a] = b
        return True
    return False


v, e = map(int, input().split())
l1 = []
s = []
parent = [0]*(v+1)

graph = [[] for _ in range(v+1)]
esum = 0 #그래프 가중치의 합 저장

for i in range(e):
    l1.append(tuple(map(int, input().split())))

for i in range(v+1):
    parent[i] = i

l1.sort(key = lambda x: x[2]) #오름차순은 l1.sort(key = lambda x: x[2], reverse = True)

graph[l1[0][0]].append(l1[0][1])
graph[l1[0][1]].append(l1[0][0])
union(l1[0][0], l1[0][1])
esum += l1[0][2]

for i in range(1, e):
    # s = [1]
    # visited = [False] * (v + 1)

    if union(l1[i][0], l1[i][1]):
        graph[l1[i][0]].append(l1[i][1])
        graph[l1[i][1]].append(l1[i][0])
        esum += l1[i][2]

print(esum)