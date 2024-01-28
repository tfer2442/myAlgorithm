import sys
from collections import Counter

input = sys.stdin.readline

n, d, k, c = map(int, input().split())
result = []
belt = []

for _ in range(n):
    belt.append(int(input()))

for i in range(n):
    sushi = Counter()
    for j in range(k):
        if i + j >= n:
            sushi[belt[i+j-n]] += 1
        else:
            sushi[belt[i+j]] += 1
    sushi[c] += 1
    result.append(len(sushi))


print(max(result))
