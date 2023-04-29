import sys
input = sys.stdin.readline

n = int(input())
l1 = [0]*(n+1)
l1[1] = 1
if n >= 2:
    l1[2] = 2
if n >= 3:
    l1[3] = 3
for i in range(3, n+1):
    l1[i] = l1[i-1] + l1[i-2]

print(l1[n]%10007)