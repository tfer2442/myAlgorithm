import sys
input = sys.stdin.readline

n = int(input())
l1 = []


for _ in range(n):
    l1.append(int(input()))

Dp = [0] * len(l1)
Dp[0] = l1[0]

if len(l1) >= 2:
    Dp[1] = l1[0] + l1[1]
if len(l1) >= 3:
    Dp[2] = max(l1[0] + l1[2], l1[1] + l1[2])

for i in range(3, len(l1)):
    Dp[i] = max(Dp[i-2] + l1[i], l1[i]+l1[i-1]+Dp[i-3])

print(Dp.pop())
