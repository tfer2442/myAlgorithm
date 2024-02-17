import sys
import copy
from collections import Counter
input = sys.stdin.readline

n = int(input())
firstWord = Counter(input().strip())
words = list()

for _ in range(n-1):
    words.append(Counter(input().strip()))

cnt = 0
for word in words:
    subLen = abs(len(list(word.elements())) - len(list(firstWord.elements())))
    if subLen >= 2:
        continue
    checkWord = copy.deepcopy(firstWord)
    checkWord.subtract(word)
    l1 = list(checkWord.keys())

    for w in l1:
        if checkWord[w] == 0:
            del checkWord[w]

    if subLen == 0:
        if len(checkWord) == 0:
            cnt += 1
            continue
        if len(checkWord) == 2:
            checkList = list(checkWord.keys())
            if (checkWord[checkList[0]] * checkWord[checkList[1]] == -1) and (checkWord[checkList[0]] + checkWord[checkList[1]] == 0):
                cnt += 1
                continue

    if subLen == 1:
        if len(checkWord) == 1:
            cnt += 1

print(cnt)
