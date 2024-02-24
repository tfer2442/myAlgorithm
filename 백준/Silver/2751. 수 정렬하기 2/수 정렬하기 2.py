import sys
input = sys.stdin.readline


n = int(input())
l1 = list()

for _ in range(n):
    l1.append(int(input()))

l1.sort()

for num in l1:
    print(num)