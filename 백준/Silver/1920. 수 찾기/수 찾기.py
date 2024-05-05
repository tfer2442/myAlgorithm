import sys
input = sys.stdin.readline


def binarySearch(num):
    left = 0
    right = n-1

    while left <= right:
        mid = (left+right)//2

        if myNums[mid] > num:
            right = mid - 1
        elif myNums[mid] < num:
            left = mid + 1
        elif myNums[mid] == num:
            return True
    return False


n = int(input())
myNums = list(map(int, input().split()))
m = int(input())
compareNums = list(map(int, input().split()))

myNums.sort()

for num in compareNums:
    check = binarySearch(num)

    if check:
        print(1)
    elif not check:
        print(0)
