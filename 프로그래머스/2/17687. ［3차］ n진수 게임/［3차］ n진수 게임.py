# p, x*m + p

def decimalToK(num, k):
    d = {0: '0', 1: '1', 2: '2', 3: '3', 4: '4', 5: '5', 6: '6', 7: '7', 8: '8', 9: '9', 10: 'A', 11: 'B', 12: 'C', 13: 'D', 14: 'E', 15: 'F'}
    answer = ""
    
    while num >= k:
        answer += d[num%k]
        num = num//k
        
    answer += d[num%k]
    return answer[::-1]


def solution(n, t, m, p):
    answer = ''
    result = ''
    i = 0
    
    while len(result) < (t*m-(m-p)):
        result += decimalToK(i, n)
        i += 1
    print(result)

    for i in range(t):
        answer += result[i*m + (p-1)]
                
        
    return answer