import sys
input = sys.stdin.readline

n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

a.sort()
b.sort(reverse=True)

total = 0
for i in range(n):
    total += a[i] * b[i]
print(total)