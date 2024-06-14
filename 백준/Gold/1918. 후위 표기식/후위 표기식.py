import sys
input = sys.stdin.readline

equation = input().strip()
stack = []

for e in equation:
    if 'A' <= e <= 'Z':
        print(e, end='')
        continue

    if e == '(':
        stack.append(e)
        continue

    if e == '*' or e == '/':
        while stack and (stack[-1] == '*' or stack[-1] == '/'):
            print(stack.pop(), end='')
        stack.append(e)
        continue
    if e == '+' or e == '-':
        while stack and stack[-1] != '(':
            print(stack.pop(), end='')
        stack.append(e)
        continue
    if e == ')':
        while stack and (stack[-1] != '('):
            print(stack.pop(), end='')
        stack.pop()

while stack:
    print(stack.pop(), end='')
