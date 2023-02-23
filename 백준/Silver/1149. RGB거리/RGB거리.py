import sys
input = sys.stdin.readline

n = int(input())

l1 = list(map(int, input().split()))
dp = [l1[0], l1[1], l1[2]]
dp2 = [l1[0], l1[1], l1[2]]
for i in range(1, n):
    l1 = list(map(int, input().split()))
    dp[0] = min(l1[0] + dp2[1], l1[0] + dp2[2])
    dp[1] = min(l1[1] + dp2[0], l1[1] + dp2[2])
    dp[2] = min(l1[2] + dp2[0], l1[2] + dp2[1])
    dp2[0], dp2[1], dp2[2] = dp[0], dp[1], dp[2]
print(min(dp))