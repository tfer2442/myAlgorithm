import sys
input = sys.stdin.readline

n = int(input())
s = set()

for i in range(n):
    tmp = input().strip()

    if tmp == 'empty':
        s = set()
        continue
    if tmp == 'all':
        s = set(range(1, 21))
        continue

    command, x = tmp.split()
    x = int(x)

    if command == 'add':
        s.add(x)
        continue
    if command == 'remove':
        if x in s:
            s.remove(x)
        continue
    if command == 'check':
        if x in s:
            print(1)
            continue
        if x not in s:
            print(0)
            continue
    if command == 'toggle':
        if x in s:
            s.remove(x)
            continue
        if x not in s:
            s.add(x)
            continue
