import sys
input = sys.stdin.readline

n, m = map(int, input().split())
dp = [[0]*(n+1) for _ in range(m+1)]
book = []

for i in range(m):
    book.append(list(map(int, input().split())))

book.sort(key=lambda x: (x[0], x[1]))
answer = 0

for i in range(1, m+1):
    for j in range(n+1):
        if j < book[i - 1][0]:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j - book[i - 1][0]] + book[i - 1][1])
        answer = max(dp[i][j], answer)

print(answer)
