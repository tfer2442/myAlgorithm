import sys
input = sys.stdin.readline

names = input().strip().split('-')
shortNames = ""

for name in names:
    shortNames += name[0]

print(shortNames)