import sys
input = sys.stdin.readline

n = int(input())
l1 = list(map(int, input().split()))

dp = [1] * n

for i in range(1, n):
    for j in range(i):
        if l1[i] > l1[j] and dp[j] >= dp[i]:
            dp[i] = dp[j]+1

print(max(dp))