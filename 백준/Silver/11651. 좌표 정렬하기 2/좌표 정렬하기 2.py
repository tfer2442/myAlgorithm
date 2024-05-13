import sys
input = sys.stdin.readline

n = int(input())
nums = []

for _ in range(n):
    nums.append(list(map(int, input().split())))

nums.sort(key=lambda x: (x[1], x[0]))

for i in range(n):
    print(nums[i][0], nums[i][1])
