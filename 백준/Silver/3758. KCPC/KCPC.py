import sys
input = sys.stdin.readline

T = int(input())

for i in range(T):
    n, k, t, m = map(int, input().split())
    tryNums = [0] * n
    lastSubmit = [0] * n
    totals = [[0]*n for _ in range(k)]
    for j in range(m):
        teamId, problem, score = map(int, input().split())
        lastSubmit[teamId-1] = j
        tryNums[teamId-1] += 1
        if totals[problem-1][teamId-1] <= score:
            totals[problem-1][teamId-1] = score

    total = [0] * n
    for j in range(n):
        for p in range(k):
            total[j] += totals[p][j]

    rank = 1
    for p in range(n):
        if p == t-1:
            continue
        if total[t-1] < total[p]:
            rank += 1
        elif total[t-1] == total[p]:
            if tryNums[t-1] > tryNums[p]:
                rank += 1
            elif tryNums[t-1] == tryNums[p]:
                if lastSubmit[t-1] > lastSubmit[p]:
                    rank += 1
    print(rank)
