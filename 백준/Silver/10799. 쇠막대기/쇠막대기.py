import sys
input = sys.stdin.readline

hands = input().strip()
stack = list()
raser = list()
bar = list()
cutCnt = 0
barCnt = 0

for i, hand in enumerate(hands):
    if hand == '(':
        stack.append(i)
        continue

    if hand == ')':
        top = stack.pop()
        if i - top == 1:
            cutCnt += len(stack)
            continue
        barCnt += 1
        
print(cutCnt + barCnt)
