import sys
input = sys.stdin.readline

n = int(input())
m = int(input())

maxDistance = int(1e11)
distances = [[maxDistance] * (n+1) for _ in range(n+1)]
for i in range(1, n+1):
    distances[i][i] = 0

for _ in range(m):
    a, b, c = map(int, input().split())

    distances[a][b] = min(distances[a][b], c)

for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            distances[i][j] = min(distances[i][j], distances[i][k] + distances[k][j])

for i in range(1, n+1):
    for j in range(1, n+1):
        if distances[i][j] == maxDistance:
            print(0, end=' ')
        else:
            print(distances[i][j], end=' ')
    print()