import sys
input = sys.stdin.readline

n, m, x = map(int, input().split())
l2 = [[] for _ in range(n+1)]
l1 = [[10000000]*(n+1) for _ in range(n+1)]

for i in range(m):
    tmp1, tmp2, tmp3 = map(int, input().split())
    l1[tmp1][tmp2] = tmp3

def floydWarshall():
    for k in range(1, n + 1):
        for i in range(1, n + 1):
            if l1[i][k] != 10000000:
                for j in range(1, n + 1):
                    if i == j:
                        l1[i][j] = 0
                    else:
                        l1[i][j] = min(l1[i][j], l1[i][k] + l1[k][j])


floydWarshall()
dmax = -99999
for i in range(1, n+1):
    dmax = max(dmax, l1[i][x] + l1[x][i])
print(dmax)