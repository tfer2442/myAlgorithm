import sys
input = sys.stdin.readline


def solution(n, k):
    dp = [0] * 100001
    for i in range(n):
        dp[i] = n-i

    for i in range(n+1, k+1):
        if i % 2 != 0:
            dp[i] = min(dp[i-1] + 1, dp[(i+1) // 2] + 2)
        else:
            dp[i] = min(dp[i-1] + 1, dp[i // 2] + 1)

    return dp[k]

n, k = map(int, input().split())
print(solution(n, k))