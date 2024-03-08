import sys
input = sys.stdin.readline

stack1 = list(input().strip())
m = int(input())
stack2 = list()

for i in range(m):
    command = list(input().split())

    if command[0] == 'L':
        if stack1:
            stack2.append(stack1.pop())
        continue
    if command[0] == 'D':
        if stack2:
            stack1.append(stack2.pop())
        continue
    if command[0] == 'B':
        if stack1:
            stack1.pop()
        continue
    if command[0] == 'P':
        stack1.append(command[1])
        continue

stack1.extend(stack2[::-1])
print(*stack1, sep='')
