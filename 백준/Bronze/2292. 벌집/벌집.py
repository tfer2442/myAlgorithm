import sys
input = sys.stdin.readline


beeHouse = [1, 2]
start = 8
d = 12

while True:
    if start > 1_000_000_000:
        beeHouse.append(start)
        break
    beeHouse.append(start)
    start += d
    d += 6

n = int(input())

if n == 1:
    print(1)
else:
    for i in range(1, len(beeHouse)):
        if beeHouse[i-1] <= n < beeHouse[i]:
            print(i)
            break
