import sys
input = sys.stdin.readline

s = list(input())

for i, word in enumerate(s):
    if word.isalpha():
        if 'A' <= word <= 'M':
            s[i] = chr(ord(word) + 13)
        elif 'N' <= word <= 'Z':
            s[i] = chr(ord(word) - 13)
        elif 'a' <= word <= 'm':
            s[i] = chr(ord(word) + 13)
        elif 'n' <= word <= 'z':
            s[i] = chr(ord(word) - 13)

print(''.join(s))
