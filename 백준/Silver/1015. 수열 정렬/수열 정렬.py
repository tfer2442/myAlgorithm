import sys
input = sys.stdin.readline

n = int(input())
a = list(map(int, input().split()))
b = sorted(a)
visited = [False] * n

for i in range(n):
    for j in range(n):
        if not visited[j] and a[i] == b[j]:
            print(j, end=' ')
            visited[j] = True
            break
