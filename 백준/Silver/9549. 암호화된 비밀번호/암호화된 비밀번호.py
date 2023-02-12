import sys
input = sys.stdin.readline

T = int(input())
count = 0

a = ord('a')
for i in range(T):
    pw = input()
    pw2 = input()

    l1 = [0] * 26
    l2 = [0] * 26

    for j in range(len(pw2)-1):
        l1[ord(pw2[j]) - a] += 1

    for j in range(len(pw2)-1):
        l2[ord(pw[j]) - a] += 1

    if l1 == l2:
        print('YES')
        continue

    for k in range(len(pw2)-1, len(pw)-1):
        l2[ord(pw[k-len(pw2)+1]) - a] -= 1
        l2[ord(pw[k]) - a] += 1

        if l1 == l2:
            print('YES')
            break
    else:
        print('NO')
