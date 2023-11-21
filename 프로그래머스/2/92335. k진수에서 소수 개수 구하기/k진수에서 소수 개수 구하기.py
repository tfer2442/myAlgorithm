def decimalToK(n, k, s):
    if n == 0 or n == 1:
        return s + str(n)
    if k > n:
        return s + str(n)

    s += str(n%k)
    return decimalToK(n//k, k, s)


def isPrime(str1):
    if str1 == "" or str1 == "1":
        return 0
    num = int(str1)
    
    for i in range(2, int(num**(1/2)) + 1):
        if num % i == 0:
            return 0
    return 1
 
    
def countPrimeOfString(str1):
    tmp = ""
    countPrime = 0
    
    for s in str1:
        if s != '0':
            tmp += s
        else:
            countPrime += isPrime(tmp)
            tmp = ""
    
    return countPrime
    
def solution(n, k):
    answer = -1
    s = ""
    kNum = decimalToK(n, k, s)[::-1]
    answer = countPrimeOfString(kNum+"0")
    
    return answer