import sys
input = sys.stdin.readline

n = int(input())
L = list(map(int, input().split()))
J = list(map(int, input().split()))

dp = [[0]*100 for _ in range(n+1)]
people = []

for i in range(n):
    people.append((L[i], J[i]))

people.sort(key=lambda x: (x[0], x[1]))
answer = 0

for i in range(1, n+1):
    for j in range(100):
        if j < people[i-1][0]:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-people[i-1][0]]+people[i-1][1])
        answer = max(dp[i][j], answer)

print(answer)