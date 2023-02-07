import sys
input = sys.stdin.readline

n, m = map(int, input().split())

s = []
check = []
count = 0

for i in range(n):
    s.append(input())

for i in range(m):
    check.append(input())

for i in range(m):
    if check[i] in s:
        count = count + 1

print(count)
