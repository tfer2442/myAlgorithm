# 리스트 remove 함수
# 중복순열

import sys
from itertools import permutations, product

input = sys.stdin.readline

n = int(input())
m = int(input())

if m == 0:
    print(min(abs(100-n), len(str(n))))
    exit(0)

l1 = list((map(int, input().split())))

if n == 100:
    print(0)
    exit(0)

if m == 10:
    print(abs(100-n))
    exit(0)

l2 = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
for tmp in l1:
    if tmp in l2:
        l2.remove(tmp)
l3 = []

for i in range(len(str(n))):
    for j in product(l2, repeat=len(str(n))-i):
        l3.append(j)
for j in product(l2, repeat=len(str(n))+1):
    l3.append(j)
l4 = []

for tmp in l3:
    s = ''
    for tmp2 in tmp:
        s += str(tmp2)
    l4.append(int(s))
target = 9999999
cnt = 0
l4.sort()
for i in range(len(l4)):
    if abs(l4[i] - n) < target:
        target = abs(l4[i] - n)
        cnt = i

print(min(abs(100-n), target + len(str(l4[cnt]))))
