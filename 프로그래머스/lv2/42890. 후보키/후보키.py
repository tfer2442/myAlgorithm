from itertools import combinations

def solution(relation):
    col = len(relation[0])
    row = len(relation)
    cblist = [i for i in range(col)]
    visited = []
    cnt = 0
    answer = 0

    for i in range(1, col+1):
        for cbtmp in combinations(cblist, i):
            l1 = []
            flag = 0
            
            for j in range(1, i):
                for tmp in combinations(cbtmp, j):
                    if list(tmp) in visited:
                        flag = 1
                        break
                if flag == 1:
                    break
            if flag == 1:
                continue
            
            for j in relation:
                s = ""
                for k in cbtmp:
                    s += j[k] + " "
                l1.append(s)
            
            s1 = set(l1)

            if len(l1) == len(s1):             
                cnt += 1
                visited.append(list(cbtmp))
                #print(visited)
                
    answer = cnt
    return answer