# list, tuple로 in 사용하면 O(n)이다.
# set, dictionary로 사용하면 평균 O(1) 최악 O(n)이다. hash로 값을 저장하기 때문에

import sys
input = sys.stdin.readline

n, m = map(int, input().split())

s = set()
check = []
count = 0

for i in range(n):
    s.add(input())

for i in range(m):
    check.append(input())

for i in range(m):
    if check[i] in s:
        count = count + 1

print(count)
