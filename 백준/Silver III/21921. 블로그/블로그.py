import sys
input = sys.stdin.readline


def printMaxValueCount():
    if maxValue == 0:
        print('SAD')
        return

    print(maxValue)
    print(totalNums.count(maxValue))


n, x = map(int, input().split())
visitedNums = list(map(int, input().split()))

total = sum(visitedNums[:x])
totalNums = [total]

for i in range(x, n):
    total = total - visitedNums[i-x] + visitedNums[i]
    totalNums.append(total)

maxValue = max(totalNums)

printMaxValueCount()
