import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
d = deque(range(1, n+1))
lenOfd = len(d)
while True:
    if lenOfd == 1:
        print(d.pop())
        break

    d.popleft()
    lenOfd -= 1
    d.append(d.popleft())

