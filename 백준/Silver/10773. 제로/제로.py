import sys
input = sys.stdin.readline

k = int(input())
money = []

for _ in range(k):
    tmp = int(input())

    if tmp == 0:
        money.pop()
        continue
    money.append(tmp)

print(sum(money))
