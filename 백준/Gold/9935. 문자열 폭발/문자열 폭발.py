import sys
input = sys.stdin.readline

str1 = input().strip()
str2 = input().strip()
stack1 = []

for i in range(len(str1)):
    stack1.append(str1[i])
    if str1[i] == str2[-1]:
        if len(stack1) < len(str2):
            continue
        if ''.join(stack1[len(stack1)-len(str2):]) == str2:
            for j in range(len(str2)):
                stack1.pop()

if stack1:
    print(''.join(stack1))
else:
    print('FRULA')