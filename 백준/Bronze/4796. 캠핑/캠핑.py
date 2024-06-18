import sys
input = sys.stdin.readline
i = 0
while True:
    L, P, V = map(int, input().split())

    if L == 0:
        break

    i += 1
    term = V // P
    lastDay = V % P

    answer = term * L + min(lastDay, L)
    print('Case %d:' % i, answer)
