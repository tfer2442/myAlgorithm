import sys
input = sys.stdin.readline

n = int(input())

s = []

l1 = list(map(int, input().split()))

cnt = 0
iSum = 0

if n == 1:
    s.append(l1[0])

for i in range(n):
    if l1[i] < 0:
        cnt += 1
    if l1[i] > 0:
        cnt -= 1

    if l1[i] >= 0:
        iSum = iSum + l1[i]
    elif l1[i] < 0 and iSum < abs(l1[i]):
        s.append(iSum)
        iSum = 0
    elif l1[i] < 0:
        s.append(iSum)
        iSum = iSum + l1[i]

if cnt == n:
    print(max(l1))
elif cnt == -n:
    print(iSum)
else:
    print(max(s))
