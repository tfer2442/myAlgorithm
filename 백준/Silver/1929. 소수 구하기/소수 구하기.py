import sys
import math
input = sys.stdin.readline


def isPrime(num):
    for i in range(2, int(math.sqrt(num))+1):
        if num % i == 0:
            return False
    return True


m, n = map(int, input().split())

for num in range(m, n+1):
    if num == 1:
        continue
    if isPrime(num):
        print(num)
