import sys
input = sys.stdin.readline


def solution():
    answer = 10_000_000_000
    one, two, three = values[0], values[1], values[n - 1]

    for i in range(n - 2):
        left = i + 1
        right = n - 1

        while left < right:
            total = values[i] + values[left] + values[right]

            if answer > abs(total):
                answer = abs(total)
                one, two, three = values[i], values[left], values[right]

            if total > 0:
                right -= 1
            elif total < 0:
                left += 1
            else:
                print(one, two, three)
                return

    print(one, two, three)


n = int(input())
values = list(map(int, input().split()))
values.sort()
solution()
