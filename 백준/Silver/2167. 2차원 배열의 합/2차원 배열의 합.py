import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = []

for _ in range(n):
    arr.append(list(map(int, input().split())))

k = int(input())

for m in range(k):
    i, j, x, y = map(int, input().split())
    total = 0
    for n in range(x-i+1):
        total += sum(arr[i+n-1][j-1:y])
    print(total)
