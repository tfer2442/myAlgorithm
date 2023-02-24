import sys
input = sys.stdin.readline

t = int(input())

l1 = [1, 1, 1, 2, 2, 3, 4, 5, 7, 9, 12]
for i in range(11, 101):
    l1.append(l1[i-1] + l1[i-5])
for _ in range(t):
    n = int(input())
    n = n - 1
    print(l1[n])
