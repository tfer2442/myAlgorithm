import sys
input = sys.stdin.readline

# dp[i]: i번 째 index에는 숫자 i를 /3, /2, -1 했을 때 연산의 최솟값이 들어있음.

n = int(input())
dp = [0] * (n + 1)
for i in range(2, n + 1):
    dp[i] = i

for i in range(2, n + 1):
    if i % 3 == 0:  # 3으로 나누어진다면 dp[i]와 dp[i//3]을 비교해서 작은 값을 넣음.
        dp[i] = min(dp[i], dp[i // 3])
    if i % 2 == 0:  # 2로 나누어진다면 dp[i]와 dp[i//2]을 비교해서 작은 값을 넣음.
        dp[i] = min(dp[i], dp[i // 2])
    dp[i] = min(dp[i], dp[i - 1]) + 1
    # 최종적으로 dp[i//3], dp[i//2], dp[i-1]의 최솟값을 구하게 됨.

print(dp[n])

while n != 1:
    print(n, end=' ')

    if n % 3 == 0 and dp[n] == dp[n//3] + 1:
        n = n//3 # /가 아니고 //이다. /로 하면 float가 들어가서 index참조 할 때 오류가 생김
    elif n % 2 == 0 and dp[n] == dp[n//2] + 1:
        n = n//2
    elif dp[n] == dp[n-1] + 1:
        n = n - 1

print(1)
