import sys
from heapq import heappush, heappop
input = sys.stdin.readline


n, m = map(int, input().split())
problemGraph = [{} for _ in range(n+1)]
inDegree = [0] * (n+1)

for _ in range(m):
    prevProblem, nextProblem = map(int, input().split())
    problemGraph[prevProblem][nextProblem] = True
    inDegree[nextProblem] += 1

q = list()
for i in range(1, n+1):
    if inDegree[i] == 0:
        heappush(q, i)

while q:
    curProblem = heappop(q)
    print(curProblem, end=' ')

    for nextProblem in problemGraph[curProblem]:
        inDegree[nextProblem] -= 1
        if inDegree[nextProblem] == 0:
            heappush(q, nextProblem)
