import sys
input = sys.stdin.readline

n = int(input())
a = 0
b = 1
c = 1

for i in range(n):
    c = (a + b) % 15746
    a, b = b, c

print(c)
