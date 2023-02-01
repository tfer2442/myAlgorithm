import sys
input = sys.stdin.readline

n = int(input())
l1 = [int(input()) for _ in range(n)]
l1.sort()

c = len(l1) - 1
b = c - 1
a = b - 1

while True:
    if l1[a] + l1[b] > l1[c]:
        print(l1[a]+l1[b]+l1[c])
        break
    else:
        c = b
        b = a
        if a - 1 < 0:
            print(-1)
            break
        a = a - 1
