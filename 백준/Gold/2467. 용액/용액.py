import sys
input = sys.stdin.readline


n = int(input())
values = list(map(int, input().split()))
values.sort()

left = 0
right = n-1
answer = 10000000000
one = values[left]
two = values[right]

while left < right:
    value = values[left] + values[right]

    if answer > abs(value):
        answer = abs(value)
        one = values[left]
        two = values[right]

    if value < 0:
        left += 1
    elif value > 0:
        right -= 1
    else:
        print(one, two)
        break
else:
    print(one, two)
