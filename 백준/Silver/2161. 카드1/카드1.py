import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
cards = deque(range(1, n+1))

while True:
    print(cards.popleft(), end=' ')
    if not cards:
        break
    cards.append(cards.popleft())
