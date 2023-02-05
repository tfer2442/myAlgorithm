import sys
input = sys.stdin.readline

n, k = map(int, input().split())
l1 = []

for i in range(n):
    l1.append(int(input()))

n = n - 1
coin = 0
csum = 0

while True:
    if k == l1[n]:
        print(coin+1)
        break
    if k == 0:
        print(coin)
        break
    elif k < l1[n]:
        n = n - 1
    elif k > l1[n]:
        coin += k // l1[n]
        k = k % l1[n]
