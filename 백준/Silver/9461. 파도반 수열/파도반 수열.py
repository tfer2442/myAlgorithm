import sys
input = sys.stdin.readline

l1 = [1, 1, 1, 2, 2]
for _ in range(4, 101):
    l1.append(l1[-1] + l1[-5])
for _ in range(int(input())):
    n = int(input())
    print(l1[n-1])
