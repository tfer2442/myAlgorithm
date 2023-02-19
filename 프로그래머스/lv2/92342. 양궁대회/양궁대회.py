from itertools import combinations_with_replacement
def solution(n, info):
    l1 = []
    for i in combinations_with_replacement([10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0], n):
        l1.append(i)
        
    l2 = []
    l3 = []
    
    for i in l1:
        result = [0] * 11
        a = 0
        b = 0
        for j in i:
            result[j] += 1
        for j in range(11):
            if info[j] >= result[j]:
                if info[j] != 0:
                    a += 10-j
            else:
                b += 10-j
        if b > a:
            l2.append(result)
            l3.append(b-a)
    if not l3:
        return [-1]
    
    tmp = max(l3)
    c = l3.index(tmp)
    answer = l2[c]
    
    
    return answer