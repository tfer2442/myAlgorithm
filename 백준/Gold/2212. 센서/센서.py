import sys
input = sys.stdin.readline

n = int(input())
k = int(input())
if k >= n:
    print(0)
    sys.exit()

l1 = list(map(int, input().split()))
l2 = list()
l1.sort()
for i in range(1, n):
    l2.append(l1[i]-l1[i-1])
l2.sort(reverse = True)

for i in range(k-1):
    l2.pop(0)
print(sum(l2))

