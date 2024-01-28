import sys
from collections import Counter

input = sys.stdin.readline

n, d, k, c = map(int, input().split())
result = []
belt = []
sushi = Counter()

for _ in range(n):
    belt.append(int(input()))

for i in range(k):
    sushi[belt[i]] += 1
sushi[c] += 1
result.append(len(sushi))

for i in range(k, n+k-1):
    if i >= n:
        sushi[belt[i-n]] += 1
        sushi[belt[i-n-k]] -= 1
        tmp = belt[i-n-k]
    else:
        sushi[belt[i]] += 1
        sushi[belt[i-k]] -= 1
        tmp = belt[i-k]

    if sushi[tmp] == 0:
        del sushi[tmp]

    result.append(len(sushi))

print(max(result))
