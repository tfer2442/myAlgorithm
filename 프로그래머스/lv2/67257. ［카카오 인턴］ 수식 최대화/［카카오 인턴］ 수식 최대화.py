from itertools import permutations

def solution(expression):
    answer = 0
    l4 = []
    l5 = []
    s = ""
    for c in expression:
        if c not in "-*+":
            s += c
        else:
            l4.append(int(s))
            s = ""
            l5.append(c)
    l4.append(int(s))
            
    result = []
    for p in permutations(['*', '+', '-']):
        l1 = l4[:]
        l2 = l5[:]
        print(p)
        for i in range(len(p)):
            l3 = []
            for j in range(len(l2)):
                if l2[j] == p[i]:
                    l3.append(j)                   
            for j in range(len(l3)):
                l3[j] = l3[j]-j       
            for j in l3:
                if p[i] == '*':
                    l1[j] = l1[j] * l1[j+1]
                elif p[i] == '+':
                    l1[j] = l1[j] + l1[j+1]
                elif p[i] == '-':
                    l1[j] = l1[j] - l1[j+1]
                l1.pop(j+1)
                l2.pop(j)
        result.append(abs(l1[0]))
    answer = max(result)
    return answer