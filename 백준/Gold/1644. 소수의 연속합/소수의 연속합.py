import sys
input = sys.stdin.readline


def initPrimeList(num):
    isPrime = [False, False] + [True] * (num-1)
    for i in range(2, num+1):
        if isPrime[i]:
            primes.append(i)
            for j in range(i*2, num+1, i):
                isPrime[j] = False


n = int(input())
if n == 1:
    print(0)
    exit(0)

primes = list()
initPrimeList(n)

left = 0
right = 1
subTotal = primes[left]
cnt = 0

while left < right:
    if subTotal == n:
        cnt += 1
        if right >= len(primes):
            break
        subTotal -= primes[left]
        subTotal += primes[right]
        left += 1
        right += 1
        continue

    if subTotal < n:
        if right >= len(primes):
            break
        subTotal += primes[right]
        right += 1
        continue

    if subTotal > n:
        if left >= len(primes):
            break
        subTotal -= primes[left]
        left += 1

print(cnt)