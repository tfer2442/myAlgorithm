import sys
input = sys.stdin.readline

length, width, height = map(int, input().split())
n = int(input())
cubes = []

for _ in range(n):
    a, b = map(int, input().split())
    cubes.append([a, b])

volume = length * width * height
nums = [0] * (n+1)
nums[0] = volume

for i in range(n-1, 0, -1):
    x = length // (2**cubes[i][0])
    y = width // (2**cubes[i][0])
    z = height // (2**cubes[i][0])
    possibleBox = x * y * z

    tmp = 0
    for j in range(i+1, n):
        tmp += nums[j] * (8**(j-i))
    possibleBox -= tmp

    if possibleBox <= 0:
        continue

    value = min(possibleBox, cubes[i][1])
    nums[i] = value
    nums[0] -= value * ((2**i)**3)

if nums[0] <= cubes[0][1]:
    print(sum(nums))
else:
    print(-1)
