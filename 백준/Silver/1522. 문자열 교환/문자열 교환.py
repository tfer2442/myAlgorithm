import sys
input = sys.stdin.readline


words = list(input().strip())

bNum = words.count('b')
minValue = 99999999999999

for i in range(len(words)):
    if i + bNum > len(words):
        minValue = min(minValue, bNum - (words[i:len(words)].count('b') + words[:bNum-(len(words)-i)].count('b')))
    else:
        minValue = min(minValue, bNum - words[i:i+bNum].count('b'))
print(minValue)