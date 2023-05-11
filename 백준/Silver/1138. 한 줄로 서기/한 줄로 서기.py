import sys
input = sys.stdin.readline

n = int(input())

l1 = list(map(int, input().split()))
empty = [i for i in range(n)]
answer = [0] * n
for i in range(n):
    a = empty.pop(l1[i])
    answer[a] = i+1

print(*answer)
