import sys
from itertools import permutations

input = sys.stdin.readline


k = int(input())
l1 = input().split()
l2 = []

for s in permutations([9, 8, 7, 6, 5, 4, 3, 2, 1, 0], k+1):
    l2 = []
    for i in range(k):
        if l1[i] == '<':
            if s[i] >= s[i+1]:
                break
        elif l1[i] == '>':
            if s[i] <= s[i+1]:
                break
        l2.append(s[i])
    else:
        l2.append(s[k])
        answer = ""
        for tmp in l2:
            answer += str(tmp)
        print(answer)
        break

for s in permutations([0, 1, 2, 3, 4, 5, 6, 7, 8 ,9], k+1):
    l2 = []
    for i in range(k):
        if l1[i] == '<':
            if s[i] >= s[i+1]:
                break
        elif l1[i] == '>':
            if s[i] <= s[i+1]:
                break
        l2.append(s[i])
    else:
        l2.append(s[k])
        answer = ""
        for tmp in l2:
            answer += str(tmp)
        print(answer)
        break
