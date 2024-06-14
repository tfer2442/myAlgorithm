import sys
input = sys.stdin.readline

equation = input().strip()
stack = []
rank = {'*': 2, '/': 2, '+': 1, '-': 1}

for e in equation:
    if 'A' <= e <= 'Z':
        print(e, end='')
        continue
    if not stack:
        stack.append(e)
        continue
    if e == '(':
        stack.append(e)
        continue
    if e == ')':
        for i in range(len(stack)-1, -1, -1):
            if stack[i] == '(':
                stack.pop()
                break
            else:
                print(stack.pop(), end='')
        continue
    for i in range(len(stack) - 1, -1, -1):
        if stack[-1] == '(':
            stack.append(e)
            break
        if rank[stack[-1]] >= rank[e]:
            print(stack.pop(), end='')
        else:
            stack.append(e)
            break
    else:
        stack.append(e)

while stack:
    print(stack.pop(), end='')
