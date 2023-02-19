import sys
input = sys.stdin.readline

n = int(input())

if n == 0:
    print(0)
else:
    fac = n
    for i in range(n - 1, 0, -1):
        fac = fac * i

    fac = str(fac)
    cnt = 0
    for i in range(len(fac) - 1, -1, -1):
        if fac[i] == '0':
            cnt = cnt + 1
        else:
            break
    print(cnt)

