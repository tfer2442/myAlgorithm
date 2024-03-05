import sys
input = sys.stdin.readline

n = int(input())
triangle = []

for _ in range(n):
    triangle.append(list(map(int, input().split())))

for i in range(1, n):
    triangle[i][0] += triangle[i-1][0]
    triangle[i][i] += triangle[i-1][i-1]

for i in range(1, n):
    for j in range(1, i):
        triangle[i][j] += max(triangle[i-1][j], triangle[i-1][j-1])

print(max(triangle[n-1]))
