import sys

input = sys.stdin.readline

n, m = map(int, input().split())
d1 = {}
d2 = {}

for i in range(1, n + 1):
    tmp = input().rstrip()
    d1[tmp] = i
    d2[i] = tmp

for i in range(m):
    tmp = input().rstrip()
    if ord('A') <= ord(tmp[0]) <= ord('Z'):
        print(d1[tmp])
    else:
        print(d2[int(tmp)])
