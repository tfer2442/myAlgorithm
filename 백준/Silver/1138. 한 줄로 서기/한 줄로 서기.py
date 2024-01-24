import sys
input = sys.stdin.readline

n = int(input())
l1 = list(map(int, input().split()))
location = [-1] * n

for i in range(n):
    cnt = 0
    for j in range(n):
        if cnt == l1[i]:
            for k in range(j, n):
                if location[k] == -1:
                    location[k] = i + 1
                    break
            break
        if location[j] == -1:
            cnt += 1

print(*location)