import sys
input = sys.stdin.readline

a, b, c = map(int, input().split())

def square(a, b):
    if b == 0:
        return 1

    x = square(a, b//2)
    if b % 2 == 0:
        return x * x % c
    else:
        return x * x * a % c

print(square(a,b))

