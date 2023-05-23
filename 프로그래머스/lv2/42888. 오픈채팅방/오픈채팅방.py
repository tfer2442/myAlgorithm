def solution(record):
    answer = []
    l1 = []
    d1 = {}

    for tmp in record:
        l1 = list(tmp.split(' '))
        
        if l1[0] == 'Enter':
            d1[l1[1]] = l1[2]
            answer.append(l1[1]+"님이 들어왔습니다.")
        elif l1[0] == 'Leave':
            answer.append(l1[1]+"님이 나갔습니다.")
        elif l1[0] == 'Change':
            d1[l1[1]] = l1[2]
    
    for j in range(len(answer)):
        l2 = answer[j].split('님')
        answer[j] = answer[j].replace(l2[0], d1[l2[0]])
    
    return answer