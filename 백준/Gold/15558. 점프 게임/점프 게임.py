import sys
from collections import deque

input = sys.stdin.readline

n, k = map(int, input().split())
arr = [list(map(int, input().strip())) for _ in range(2)]
visited = [[False] * (n+k) for _ in range(2)]

for i in range(2):
    for j in range(k):
        arr[i].append(n+j+1)

for i in range(2):
    for j in range(n):
        if arr[i][j] != 0:
            arr[i][j] = j+1

q = deque()
q.append((0, 0, 1))

while q:
    curRow, curCol, t = q.popleft()

    if curCol >= n-1:
        print(1)
        exit(0)

    if arr[curRow][curCol] < t:
        continue

    if visited[curRow][curCol]:
        continue

    visited[curRow][curCol] = True

    if curCol+1 < n and arr[curRow][curCol+1] > t:
        q.append((curRow, curCol+1, t+1))

    if curCol-1 >= 0 and arr[curRow][curCol-1] > t:
        q.append((curRow, curCol-1, t+1))

    if curCol+k < n+k:
        if curRow == 0 and arr[1][curCol+k] > t:
            q.append((1, curCol+k, t+1))
        elif curRow == 1 and arr[0][curCol+k] > t:
            q.append((0, curCol+k, t+1))

print(0)
