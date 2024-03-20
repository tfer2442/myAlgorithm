import sys
input = sys.stdin.readline

n = int(input())
l1 = []
dp = []

for _ in range(n):
    l1.append(int(input()))


def calDp():
    if n == 1:
        print(l1[0])
        return

    if n == 2:
        print(l1[0]+l1[1])
        return

    dp.append(l1[0])
    dp.append(l1[0]+l1[1])
    dp.append(max(l1[0]+l1[1], l1[0]+l1[2], l1[1]+l1[2]))

    for i in range(3, n):
        dp.append(max(dp[i-1], l1[i] + dp[i-2], l1[i] + l1[i-1] + dp[i-3]))
    print(max(dp))


calDp()
