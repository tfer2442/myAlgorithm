import sys
input = sys.stdin.readline

n, m = map(int, input().split())
nums = list(map(int, input().split()))
dp = [0]
sumOfnums = 0

for i, num in enumerate(nums):
    sumOfnums += num
    dp.append(sumOfnums)

for _ in range(m):
    a, b = map(int, input().split())
    print(dp[b]-dp[a-1])
