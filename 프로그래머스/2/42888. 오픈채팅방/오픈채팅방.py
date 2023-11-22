def solution(record):
    answer = []
    idDic = {}
    
    for s in record:
        l1 = s.split()
        if l1[0] == 'Enter':
            idDic[l1[1]] = l1[2]
            answer.append([l1[1], "님이 들어왔습니다."])
        elif l1[0] == 'Change':
            idDic[l1[1]] = l1[2]
        elif l1[0] == 'Leave':
            answer.append([l1[1], "님이 나갔습니다."])
            
    
    for i in range(len(answer)):
        answer[i][0] = idDic[answer[i][0]]
        answer[i] = answer[i][0] + answer[i][1]
    
    
    return answer