import sys
input = sys.stdin.readline

def dfs(cur):
    if cur == m:
        for i in range(1, m+1):
            print(l1[i], end=' ')
        print()
        l1.pop()
        return

    for i in range(1, n + 1):
        if cur == 0 and i == 1:
            l1.append(i)
            dfs(cur+1)
        elif i >= l1[cur]:
            l1.append(i)
            dfs(cur+1)
    l1.pop()


global n, m
n, m = map(int, input().split())
l1 = [-1]

dfs(0)