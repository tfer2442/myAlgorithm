import sys
input = sys.stdin.readline

def findSameNumber2(start, left, right, num):
    while left <= right:
        mid = (left + right) // 2

        if cards[mid] > num:
            right = mid - 1
        elif cards[mid] <= num:
            left = mid + 1

    return right-start+1


def findSameNumber1(start, left, right, num):
    while left <= right:
        mid = (left + right) // 2

        if cards[mid] >= num:
            right = mid - 1
        elif cards[mid] < num:
            left = mid + 1

    return start-left+1

def binarySearch(num):
    left = 0
    right = n-1
    cnt = 0

    while left <= right:
        mid = (left + right) // 2

        if cards[mid] == num:
            cnt += findSameNumber1(mid, left, mid, num)
            cnt += findSameNumber2(mid, mid, right, num)

            print(cnt-1, end=' ')
            return

        if cards[mid] > num:
            right = mid - 1
            continue

        if cards[mid] < num:
            left = mid + 1
            continue

    print(0, end=' ')


n = int(input())
cards = list(map(int, input().split()))
cards.sort()
m = int(input())
nums = list(map(int, input().split()))

for num in nums:
    binarySearch(num)
