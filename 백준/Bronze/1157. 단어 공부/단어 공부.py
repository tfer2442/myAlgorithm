import sys
from collections import Counter
input = sys.stdin.readline

words = input().strip().upper()
frequencyOfAlphabet = Counter()

for word in words:
    frequencyOfAlphabet[word] += 1

maxValue = -1

for a in frequencyOfAlphabet:
    maxValue = max(frequencyOfAlphabet[a], maxValue)

maxNums = []

for a in frequencyOfAlphabet:
    if frequencyOfAlphabet[a] == maxValue:
        maxNums.append(a)

if len(maxNums) == 1:
    print(maxNums[0])

if len(maxNums) >= 2:
    print('?')

