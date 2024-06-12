import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    N, M = map(int, input().split())
    students = []
    visited = [False] * (N+1)

    for _ in range(M):
        students.append(tuple(map(int, input().split())))
    students.sort(key=lambda x: x[1])

    result = 0

    for i in range(M):
        for j in range(students[i][0], students[i][1]+1):
            if not visited[j]:
                visited[j] = True
                result += 1
                break
    print(result)