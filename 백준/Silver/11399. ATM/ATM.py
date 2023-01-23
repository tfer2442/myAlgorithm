N = int(input())

p = list(map(int, input().split()))
p.sort()
sum = 0

for i in range(N):
    for j in range(i+1):
        sum += p[j]
print(sum)