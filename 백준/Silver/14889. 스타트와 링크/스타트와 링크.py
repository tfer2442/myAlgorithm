import sys
input = sys.stdin.readline
from itertools import combinations

n = int(input())

l1 = [list(map(int, input().split())) for _ in range(n)]
l2 = list(combinations(range(n), n//2))
sum1 = [0]*(len(l2)//2)
sum2 = [0]*(len(l2)//2)

cnt = 0
for i in l2[0:len(l2)//2]:
    for j in i:
        for k in i:
            sum1[cnt] += l1[j][k]
    cnt += 1

cnt = 0
for i in l2[len(l2)//2:len(l2)]:
    for j in i:
        for k in i:
            sum2[cnt] += l1[j][k]
    cnt += 1

result = 101
for i in range(len(sum1)):
    result = min(result, abs(sum1[i] - sum2[len(sum1)-i-1]))

print(result)