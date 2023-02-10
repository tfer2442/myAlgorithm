import sys
input = sys.stdin.readline
from itertools import combinations

n = int(input())

l1 = [list(map(int, input().split())) for _ in range(n)]
l2 = list(combinations(range(n), n//2))
sum1 = [0]*(len(l2)//2)
sum2 = [0]*(len(l2)//2)

cnt = 0
for i, a in zip(l2[0:len(l2)//2], l2[len(l2)//2:len(l2)]):
    for j, b in zip(i, a):
        for k, c in zip(i, a):
            sum1[cnt] += l1[j][k]
            sum2[cnt] += l1[b][c]
    cnt += 1


result = 101
for i in range(len(sum1)):
    result = min(result, abs(sum1[i] - sum2[len(sum1)-i-1]))

print(result)

