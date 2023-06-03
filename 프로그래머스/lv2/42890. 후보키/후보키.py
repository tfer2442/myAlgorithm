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
                
            if i == 1:                
                 for j in range(row):
                    l1.append(relation[j][cbtmp[0]])
            elif i == 2:
                for j in range(row):
                    l1.append((relation[j][cbtmp[0]], relation[j][cbtmp[1]]))
            elif i == 3:
                for j in range(row):
                    l1.append((relation[j][cbtmp[0]], relation[j][cbtmp[1]], relation[j][cbtmp[2]]))
            elif i == 4:
                for j in range(row):
                    l1.append((relation[j][cbtmp[0]], relation[j][cbtmp[1]], relation[j][cbtmp[2]], relation[j][cbtmp[3]]))
            elif i == 5:
                for j in range(row):
                    l1.append((relation[j][cbtmp[0]], relation[j][cbtmp[1]], relation[j][cbtmp[2]], relation[j][cbtmp[3]], relation[j][cbtmp[4]]))
            elif i == 6:
                for j in range(row):
                    l1.append((relation[j][cbtmp[0]], relation[j][cbtmp[1]], relation[j][cbtmp[2]], relation[j][cbtmp[3]], relation[j][cbtmp[4]], relation[j][cbtmp[5]]))
            elif i == 7:
                for j in range(row):
                    l1.append((relation[j][cbtmp[0]], relation[j][cbtmp[1]], relation[j][cbtmp[2]], relation[j][cbtmp[3]], relation[j][cbtmp[4]], relation[j][cbtmp[5]], relation[j][cbtmp[6]]))
            elif i == 8:
                for j in range(row):
                    l1.append((relation[j][cbtmp[0]], relation[j][cbtmp[1]], relation[j][cbtmp[2]], relation[j][cbtmp[3]], relation[j][cbtmp[4]], relation[j][cbtmp[5]], relation[j][cbtmp[6]], relation[j][cbtmp[7]]))
            
            s1 = set(l1)

            if len(l1) == len(s1):             
                cnt += 1
                visited.append(list(cbtmp))
                #print(visited)
                
    answer = cnt
    return answer