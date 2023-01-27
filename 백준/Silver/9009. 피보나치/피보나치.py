import sys
input = sys.stdin.readline

t = int(input())

dp = [0] * 46
dp[1] = 1

for i in range(2, 46):
    dp[i] = dp[i-1] + dp[i-2]

for i in range(t):
    n = int(input())
    s = []
    for j in range(45, 0, -1):
        if n-dp[j] < 0:
            pass
        elif n-dp[j] > 0:
            n = n - dp[j]
            s.append(dp[j])
        else:
            s.append(dp[j])
            break
    for j in reversed(s):
        print(j, end=' ')
    print()

