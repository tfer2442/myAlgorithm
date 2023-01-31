import sys
from itertools import permutations, combinations
input = sys.stdin.readline

n, m = map(int, input().split())

home = []
chicken = []
for i in range(n):
    tmp = list(map(int, input().split()))
    for j in range(n):
        if tmp[j] == 1:
            home.append([i, j])
        elif tmp[j] == 2:
            chicken.append([i, j])

# graph = [list(map(int, input().rstrip().split())) for _ in range(N)]
# 한 줄씩 입력 받으면서 바로 2차원 리스트 생성 하는 법

dist = [[0] * len(chicken) for i in range(len(home))]

lh = len(home)
lc = len(chicken)

for i in range(lh):
    for j in range(lc):
        dist[i][j] = abs(home[i][0] - chicken[j][0]) + abs(home[i][1] - chicken[j][1])

l1 = list(combinations(range(lc), m))
ll1 = len(l1)
sum_list = []

for i in range(ll1):
    suma = 0
    for j in range(lh):
        mina = dist[j][l1[i][0]]
        for l in l1[i]:
            mina = min(mina, dist[j][l])
        suma += mina
    sum_list.append(suma)

print(min(sum_list))
