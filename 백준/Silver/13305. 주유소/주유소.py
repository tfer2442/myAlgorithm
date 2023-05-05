import sys
input = sys.stdin.readline

n = int(input())
l2 = list(map(int, input().split()))
l1 = list(map(int, input().split()))
l2.insert(0, 0)
oil = 0

i = 0
while True:
    if i >= len(l1):
        break

    dist = 0
    for j in range(i+1, len(l1)):
        if l1[i] > l1[j]:
            for k in range(j, i, -1):
                dist += l2[k]
            oil += dist * l1[i]
            i = j
            break
    else:
        for k in range(j, i, -1):
            dist += l2[k]
        oil += dist * l1[i]
        break

print(oil)