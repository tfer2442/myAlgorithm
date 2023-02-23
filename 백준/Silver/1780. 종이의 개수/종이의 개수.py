import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**7)

n = int(input())
l1 = []
for i in range(n):
    tmp = list(map(int, input().split()))
    l1.append(tmp)

lcnt = [0, 0, 0]


def bfs(n, srow, scol):
    tmp = l1[srow][scol]
    check = 0
    for i in range(srow, srow+n):
        for j in range(scol, scol+n):
            if tmp != l1[i][j]:
                check = 1
                break
        if check == 1:
            break
    else:
        lcnt[tmp+1] += 1
        return
    bfs(n//3, srow, scol)
    bfs(n//3, srow, scol+n//3)
    bfs(n//3, srow, scol+(n//3)*2)
    bfs(n//3, srow+n//3, scol)
    bfs(n//3, srow+n//3, scol+n//3)
    bfs(n//3, srow+n//3, scol+(n//3)*2)
    bfs(n//3, srow+(n//3)*2, scol)
    bfs(n//3, srow+(n//3)*2, scol+n//3)
    bfs(n//3, srow+(n//3)*2, scol+(n//3)*2)


bfs(n, 0, 0)
print(lcnt[0])
print(lcnt[1])
print(lcnt[2])
