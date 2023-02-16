import sys
input = sys.stdin.readline

def dfs(cnt):
    for i in graph[cnt]:
        if not visited[i]:
            visited[i] = True
            dfs(i)


n = int(input())
eNum = int(input())
graph = [[] for _ in range(n+1)]

for i in range(eNum):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
visited = [False] * (n+1)

dfs(1)
print(visited.count(True) - 1)