import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
m = int(input())
s = input().strip()
d = deque()

cnt = 0
for word in s:
    if not d:
        if word == 'I':
            d.append('I')
        continue
    if d[-1] != word:
        d.append(word)
        if len(d) == n*2+1:
            d.popleft()
            d.popleft()
            cnt += 1
        continue
    d = deque()
    if word == 'I':
        d.append('I')

print(cnt)