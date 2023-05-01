import sys
input = sys.stdin.readline

N = int(input())

T = []
P = []
dp = [0]*(N+1)

for i in range(N):
    a, b = map(int, input().split())
    T.append(a)
    P.append(b)

for i in range(N-1, -1, -1):
    if i + T[i] > N:
        dp[i] = dp[i+1]
    else:
        dp[i] = max(dp[i+1], dp[i+T[i]]+P[i])
print(dp[0])