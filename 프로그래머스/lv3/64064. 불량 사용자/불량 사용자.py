from itertools import permutations

def solution(user_id, banned_id):
    answer = 0
    anslist = list()
    
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
            s1 = set(i)
            if s1 not in anslist:
                anslist.append(s1)
    answer = len(anslist)
                
    return answer