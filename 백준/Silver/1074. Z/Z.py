import sys
sys.setrecursionlimit(10**7)
input = sys.stdin.readline


# def findZ(startR, startC, tr, tc, n, startN):
#     if n == 0:
#         print(startN)
#         return
#
#     if startR <= tr < startR + 2**(n-1) and startC <= tc < startC + 2**(n-1):  # 1사분면
#         findZ(startR, startC, tr, tc, n-1, startN)
#     elif startR <= tr < startR + 2**(n-1) and startC + 2**(n-1) <= tc < startC + 2**n:  # 2사분면
#         findZ(startR, startC + 2**(n-1), tr, tc, n-1, startN + (2**n * 2**n)//4)
#     elif startR+2**(n-1) <= tr < startR + 2**n and startC <= tc < startC + 2**(n-1):  # 3사분면
#         findZ(startR + 2**(n-1), startC, tr, tc, n-1, startN + (2**n * 2**n)//2)
#     elif startR+2**(n-1) <= tr < startR + 2**n and startC + 2**(n-1) <= tc < startC + 2**n:  # 4사분면
#         findZ(startR + 2**(n-1), startC + 2**(n-1), tr, tc, n-1, startN + (2**n * 2**n)//4 + (2**n * 2**n)//2)


n, r, c = map(int, input().split())
# findZ(0, 0, r, c, n, 0)
startR = 0
startC = 0
startN = 0
while True:
    if n == 0:
        print(startN)
        break

    if startR <= r < startR + 2**(n-1) and startC + 2**(n-1) <= c < startC + 2**n:  # 2사분면
        startC = startC + 2 ** (n - 1)
        startN = startN + (2**n * 2**n)//4
    elif startR+2**(n-1) <= r < startR + 2**n and startC <= c < startC + 2**(n-1):  # 3사분면
        startR = startR + 2 ** (n - 1)
        startN = startN + (2**n * 2**n)//2
    elif startR+2**(n-1) <= r < startR + 2**n and startC + 2**(n-1) <= c < startC + 2**n:  # 4사분면
        startR = startR + 2**(n-1)
        startC = startC + 2**(n-1)
        startN = startN + (2**n * 2**n)//4 + (2**n * 2**n)//2
    n = n - 1
