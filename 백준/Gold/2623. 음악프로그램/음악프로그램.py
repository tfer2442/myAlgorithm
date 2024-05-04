import sys
from collections import deque
input = sys.stdin.readline


def connectOrder(singers):
    totalPeople = singers[0]

    for i in range(1, totalPeople):
        if singers[i+1] not in orderGraph[singers[i]]:
            orderGraph[singers[i]][singers[i + 1]] = True
            inDegree[singers[i+1]] += 1


n, m = map(int, input().split())
orderGraph = [{} for _ in range(n+1)]
inDegree = [0] * (n+1)

for _ in range(m):
    singers = list(map(int, input().split()))
    connectOrder(singers)

q = deque()
answer = []
for i in range(1, n+1):
    if inDegree[i] == 0:
        q.append(i)

while q:
    curSinger = q.popleft()
    answer.append(curSinger)

    for nextSinger in orderGraph[curSinger]:
        inDegree[nextSinger] -= 1

        if inDegree[nextSinger] == 0:
            q.append(nextSinger)

if len(answer) != n:
    print(0)
else:
    for singer in answer:
        print(singer)
