import sys
from bisect import bisect_left
input = sys.stdin.readline


n = int(input())
nums = list(map(int, input().split()))

sequence = [nums[0]]
stack = [(nums[0], 0)]

for i in range(1, n):
    insertIndex = bisect_left(sequence, nums[i])

    if insertIndex < len(sequence):
        sequence[insertIndex] = nums[i]
    else:
        sequence.append(nums[i])
    stack.append((nums[i], insertIndex))

cnt = len(sequence)-1
answer = []

while cnt >= 0:
    value, index = stack.pop()
    if index == cnt:
        answer.append(value)
        cnt -= 1

print(len(answer))
print(*answer[::-1])

