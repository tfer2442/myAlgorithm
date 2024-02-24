import sys
input = sys.stdin.readline

n = int(input())
l1 = list()
stack = list()
printList = list()
cnt = 1

for _ in range(n):
    l1.append(int(input()))

def solution():
    global cnt

    for i in range(n):
        while True:
            if not stack:
                if cnt > n:
                    print('NO')
                    return
                stack.append(cnt)
                cnt += 1
                printList.append('+')
                continue

            if stack[-1] > l1[i]:
                stack.pop()
                printList.append('-')
                continue

            if stack[-1] == l1[i]:
                stack.pop()
                printList.append('-')
                break

            if stack[-1] < l1[i]:
                if cnt > n:
                    print('NO')
                    return
                stack.append(cnt)
                cnt += 1
                printList.append('+')
                continue

    for sign in printList:
       print(sign)

solution()
