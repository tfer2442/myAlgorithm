import sys
from collections import Counter, deque

input = sys.stdin.readline

n, k = map(int, input().split())
count = Counter()
l1 = deque()
nums = list(map(int, input().split()))
longest = []
cnt = 0

for num in nums:
    if count[num] == k:
        longest.append(cnt)
        while True:
            if not l1:
                break
            tmp = l1.popleft()
            count[tmp] -= 1
            cnt -= 1
            if tmp == num:
                break

    l1.append(num)
    count[num] += 1
    cnt += 1


longest.append(cnt)

print(max(longest))
