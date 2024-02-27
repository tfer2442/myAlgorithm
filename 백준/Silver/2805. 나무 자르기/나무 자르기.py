import sys
input = sys.stdin.readline


def sumTrees(h):
    total = 0

    for tree in trees:
        if tree > h:
            total += tree - h
    return total


n, m = map(int, input().split())
trees = list(map(int, input().split()))

left = 0
right = max(trees)
mid = (left + right) // 2
prevMid = 0
total = 0

while True:
    total = sumTrees(mid)
    if left >= right:
        if m > total:
            print(mid-1)
        else:
            print(mid)
        break
    if total == m:
        print(mid)
        break

    if total > m:
        left = mid + 1
        mid = (left + right) // 2
    elif total < m:
        right = mid
        mid = (left + right) // 2
