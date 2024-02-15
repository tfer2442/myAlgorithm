import sys
input = sys.stdin.readline


n, m = map(int, input().split())
keyword = set()

for _ in range(n):
    keyword.add(input().strip())

for _ in range(m):
    blogPost = set(input().strip().split(','))

    for word in blogPost:
        keyword.discard(word)

    print(len(keyword))
