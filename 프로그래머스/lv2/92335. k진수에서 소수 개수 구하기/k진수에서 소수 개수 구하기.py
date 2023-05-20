import math
def pn(a):
    if a == 1 or a == 0:
        return True
    for i in range(2, int(math.sqrt(a)+1)):
        if a % i == 0:
            return True
    return False
            

def solution(n, k):
    origin = n
    answer = 0
    l1 = []
    
    while True:
        if n < k:
            l1.append(n % k)
            break
        l1.append(n % k)
        n = n // k
    l1.reverse()
    l1.append(0)
    
    s = "0"
    
    for i in range(len(l1)):
        if l1[i] != 0:
            s += str(l1[i])
        else:
            print(int(s), i)
            if pn(int(s)) == False:
                print(True)
                answer += 1
            s = "0"
        
    return answer