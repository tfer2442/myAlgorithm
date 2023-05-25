from itertools import permutations

def solution(user_id, banned_id):
    answer = 0
    ansset = set()
    
    for i in permutations(user_id, len(banned_id)):
        flag = 1
        for j in range(len(banned_id)):
            if len(banned_id[j]) != len(i[j]):
                break
            for k in range(len(banned_id[j])):
                if (banned_id[j][k] == i[j][k]) or (banned_id[j][k] == '*'):
                    continue
                else:
                    flag = 0
                    break
            if flag == 0:
                break
        else:
            l1 = list(i)
            l1.sort()
            ansset.add(tuple(l1))
    answer = len(ansset)
                
                        
            
    
    return answer