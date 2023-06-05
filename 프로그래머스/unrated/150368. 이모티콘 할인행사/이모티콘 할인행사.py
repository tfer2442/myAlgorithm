from itertools import product

def solution(users, emoticons):
    answer = [0, 0]
    rate = [40] * len(emoticons)
    dcemo = [0] * len(emoticons)
    anslist = []
    
    for tmp in product([10, 20, 30, 40], repeat=len(emoticons)):
        for i in range(len(tmp)):
            dcemo[i] = int((emoticons[i] * (100-tmp[i]))//100)            
        pluscnt = 0
        usertotal = 0
        for i in range(len(users)):
            total = 0
            for j in range(len(tmp)):
                if tmp[j] >= users[i][0]:
                    total += dcemo[j]
            if total >= users[i][1]:
                pluscnt += 1
            else:
                usertotal += total
        anslist.append((pluscnt, usertotal, tmp[:]))
    anslist.sort(key = lambda x : (-x[0], -x[1]))
    answer[0] = anslist[0][0]
    answer[1] = anslist[0][1]
        
    return answer