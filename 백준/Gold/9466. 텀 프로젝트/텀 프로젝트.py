import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline


def dfs(node):
    global cnt

    visited[node] = True
    team.append(node)
    wantNum = friends[node]

    if visited[wantNum]:
        if wantNum in team:
            cnt += team.index(wantNum)
        else:
            cnt += len(team)
    else:
        dfs(wantNum)


T = int(input())

for _ in range(T):
    n = int(input())
    friends = [0] + list(map(int, input().split()))

    visited = [False] * (n+1)
    cnt = 0

    for i in range(1, n+1):
        if visited[i]:
            continue
        team = []
        dfs(i)
    print(cnt)