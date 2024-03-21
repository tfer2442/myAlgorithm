import sys
input = sys.stdin.readline

x, y, p1, p2 = map(int, input().split())

l1 = [p1]
l2 = [p2]

for i in range(10000):
    l1.append(l1[i]+x)
for i in range(10000):
    l2.append(l2[i]+y)

for num1 in l1:
    if num1 in l2:
        print(num1)
        break
else:
    print(-1)