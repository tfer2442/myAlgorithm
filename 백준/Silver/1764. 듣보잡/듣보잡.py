import sys
input = sys.stdin.readline
import heapq
n, m = map(int, input().split())
ear = {}
l1 = []
cnt = 0
for i in range(n):
    ear[input().rstrip()] = True
for i in range(m):
    eye = input().rstrip()
    if ear.get(eye):
        l1.append(eye)
l1.sort()
print(len(l1))
for i in l1:
    print(i)