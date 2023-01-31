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

for i in range(len(home)):
    for j in range(len(chicken)):
        dist[i][j] = abs(home[i][0] - chicken[j][0]) + abs(home[i][1] - chicken[j][1])

l1 = list(combinations(range(len(chicken)), m))
sum_list = []

for i in range(len(l1)):
    suma = 0

    for j in range(len(home)):
        min_list = []
        for l in l1[i]:
            min_list.append(dist[j][l])
        suma += min(min_list)
    sum_list.append(suma)

print(min(sum_list))
