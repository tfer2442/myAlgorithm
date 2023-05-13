import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**7)


def dfs(a, b, c):
    global hn
    if l1[a][b+1] == 1 and (visited[a][b+1] == 0):
        visited[a][b+1] = c
        hn += 1
        dfs(a, b+1, c)
    if l1[a+1][b] == 1 and (visited[a+1][b] == 0):
        visited[a+1][b] = c
        hn += 1
        dfs(a+1, b, c)
    if l1[a-1][b] == 1 and (visited[a-1][b] == 0):
        visited[a-1][b] = c
        hn += 1
        dfs(a-1, b, c)
    if l1[a][b-1] == 1 and (visited[a][b-1] == 0):
        visited[a][b-1] = c
        hn += 1
        dfs(a, b-1, c)


n = int(input())
l1 = [[0]*(n+2) for _ in range(n+2)]
visited = [[0]*(n+2) for _ in range(n+2)]
cnt = 1

for i in range(n):
    tmp = input()
    for j in range(n):
        l1[i+1][j+1] = int(tmp[j])


hl = []
for i in range(1, n+1):
    for j in range(1, n+1):
        if l1[i][j] == 1 and visited[i][j] == 0:
            hn = 0
            dfs(i, j, cnt)
            if hn == 0:
                hn = 1
            hl.append(hn)
            cnt += 1

hl.sort()
print(len(hl))
for i in hl:
    print(i)


