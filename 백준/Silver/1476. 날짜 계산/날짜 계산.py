import sys
input = sys.stdin.readline

e, s, m = map(int, input().split())
a, b, c = 1, 1, 1
cnt = 1

while True:
    if e == a and s == b and m == c:
        print(cnt)
        break

    cnt += 1

    if 1 <= a < 15:
        a += 1
    elif a == 15:
        a = 1

    if 1 <= b < 28:
        b += 1
    elif b == 28:
        b = 1

    if 1 <= c < 19:
        c += 1
    elif c == 19:
        c = 1
