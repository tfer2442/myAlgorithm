import sys
sys.setrecursionlimit(10**7)
input = sys.stdin.readline

n = int(input())
tree1 = [{} for _ in range(n+1)]
visited = [False] * (n+1)
rootWeight = [0] * (n+1)

for i in range(n-1):
    a, b, c = map(int, input().split())
    tree1[a][b] = c
    tree1[b][a] = c


def dfs(node, weight):
    visited[node] = True
    for v in tree1[node]:
        if not visited[v]:
            rootWeight[v] = weight + tree1[node][v]
            dfs(v, weight + tree1[node][v])


dfs(1, 0)
maxLeafValue = max(rootWeight)
maxLeaf = rootWeight.index(maxLeafValue)
visited = [False] * (n+1)

dfs(maxLeaf, 0)
maxLeafValue = max(rootWeight)
print(maxLeafValue)