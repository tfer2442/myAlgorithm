import sys
from collections import Counter
input = sys.stdin.readline


n, m = map(int, input().split())
keyword = Counter()

for _ in range(n):
    keyword[input().strip()] = 1

for _ in range(m):
    blogPost = list(input().strip().split(','))

    for word in blogPost:
        keyword[word] -= 1
        if keyword[word] <= 0:
            del keyword[word]

    print(len(keyword))

