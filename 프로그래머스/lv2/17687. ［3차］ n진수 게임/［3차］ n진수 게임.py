def changeNum(num, n, tmpanswer, d1):
    l1 = []
    while True:
        if num == 0:
            l1.append(0)
            break
        if num < n:
            l1.append(num)
            break
        l1.append(num % n)
        num = num//n
    l1.reverse()
    
    for i in range(len(l1)):
        if 10 <= l1[i] <= 15:
            l1[i] = d1[l1[i]]
            
    for i in range(len(l1)):
        tmpanswer.append(l1[i])

def solution(n, t, m, p):
    answer = ''
    tmpanswer = []
    d1 = {10: 'A', 11: 'B', 12: 'C', 13: 'D', 14: 'E', 15: 'F'}
    for i in range(t*m):
        changeNum(i, n, tmpanswer, d1)
    for i in range(t):
        answer += str(tmpanswer[p+(i*m)-1])
    return answer