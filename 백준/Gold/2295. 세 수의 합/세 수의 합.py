import sys

input = sys.stdin.readline;

n = int(input())
l1 = []
s = set()

for _ in range(n):
    l1.append(int(input()))

for i in range(n):
    for j in range(n):
        s.add(l1[i] + l1[j])

l1.sort()
result = []

for i in range(n):
    for j in range(i+1, n):
        if l1[j]-l1[i] in s:
            result.append(l1[j])

print(max(result))
