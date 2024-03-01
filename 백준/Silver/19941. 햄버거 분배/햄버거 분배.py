import sys
from collections import deque
input = sys.stdin.readline

n, k = map(int, input().split())
table = list(input().strip())
hamburger = deque()
people = deque()


for i, element in enumerate(table):
    if element == 'H':
        hamburger.append(i)
        continue
    if element == 'P':
        people.append(i)
        continue

cnt = 0
while hamburger and people:
    hamburgerIndex = hamburger[0]

    if 0 < people[0] - hamburgerIndex <= k:
        hamburger.popleft()
        people.popleft()
        cnt += 1
        continue

    if k < people[0] - hamburgerIndex:
        hamburger.popleft()
        continue

    if 0 < hamburgerIndex - people[0] <= k:
        hamburger.popleft()
        people.popleft()
        cnt += 1
        continue

    if k < hamburgerIndex - people[0]:
        people.popleft()
        continue

print(cnt)
