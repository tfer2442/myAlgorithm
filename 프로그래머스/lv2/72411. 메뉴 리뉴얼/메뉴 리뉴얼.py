from itertools import combinations

def solution(orders, course):
    answer = []
    odlist = []
    tmp = []
    
    for i in orders:
        odlist.append(list(i))
    
    for i in course:
        d1 = dict()

        for j in odlist:
            if len(j) < i: continue          
            for k in combinations(j, i):
                k = list(k)
                k.sort()
                k = tuple(k)
                if k in d1:
                    d1[k] += 1
                else:
                    d1[k] = 1
        maxd1 = 0            
        for k in d1:
            if maxd1 <= d1[k]:
                maxd1 = d1[k]
        if maxd1 <= 1: continue
        
        for k in d1:
            if d1[k] == maxd1:
                tmp.append(k)     
    for k in tmp:
        s = ""
        for l in k:
            s += l
        answer.append(s)
    answer.sort()    
    return answer