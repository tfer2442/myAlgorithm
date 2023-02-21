import sys
import re
from collections import deque
input = sys.stdin.readline

cal = input().strip()
l1 = deque()
l2 = deque()
s1 = []
s2 = []
l1 = deque(re.split("[+-]", cal))
l2 = deque(re.split("[0-9]", cal))

l1 = deque(filter(None, l1))
l2 = deque(filter(None, l2))

s1.append(l1.popleft())


while True:
    if not l1:
        for i in range(0, len(s2)):
            b = s1.pop()
            a = s1.pop()
            if int(b) < 0:
                if len(s2) == 1:
                    s1.append(int(b) + int(a))
                else:
                    s1.append(int(b) - int(a))
            else:
                if len(s2) == 1:
                    s1.append(int(a) - int(b))
                else:
                    s1.append(-int(a) - int(b))
            s2.pop()
        break
    s1.append(l1.popleft())
    s2.append(l2.popleft())
    if s2[-1] == '+':
        a = s1.pop()
        b = s1.pop()
        s1.append(int(a)+int(b))
        s2.pop()

print(s1.pop())