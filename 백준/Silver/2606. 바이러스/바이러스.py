import sys
input = sys.stdin.readline

def dfs(cnt):
    for i in graph[cnt]:
        if not visited[i]:
            visited[i] = 1
            dfs(i)


n = int(input())
eNum = int(input())
graph = [[] for _ in range(n+1)]

for i in range(eNum):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
visited = [0] * (n+1)
dfs(1)
visited[1] = 1
print(sum(visited) - 1)