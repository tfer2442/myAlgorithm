import sys
input = sys.stdin.readline

m = int(input())
total = 0
xor = 0

for i in range(m):
    command = list(map(int, input().split()))

    if command[0] == 3:
        print(total)
    elif command[0] == 4:
        print(xor)
    elif command[0] == 1:
        total += command[1]
        xor = xor ^ command[1]
    elif command[0] == 2:
        total -= command[1]
        xor = xor ^ command[1]

