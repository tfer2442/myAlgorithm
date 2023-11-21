def solution(msg):
    dicStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    dic1 = {}
    answer = []
    
    for i, d in enumerate(dicStr):
        dic1[d] = i+1
    
    tmp = ""
    jump = 0
    curDicNum = len(dicStr)
    for i, s in enumerate(msg):
        if jump >= 1:
            jump -= 1
            continue
            
        tmp = msg[i]
        
        for j, s2 in enumerate(msg[i+1:]):
            if tmp in dic1:
                tmp += s2
            else:
                answer.append(dic1[tmp[:len(tmp)-1]])
                curDicNum += 1
                dic1[tmp] = curDicNum
                jump = len(tmp) - 2
                break
        else:
            curDicNum += 1
            if tmp in dic1:
                answer.append(dic1[tmp])
                jump = len(tmp) - 1
            else:
                dic1[tmp] = curDicNum
                answer.append(dic1[tmp[:len(tmp)-1]])
                jump = len(tmp)-2

    return answer