def solution(s):
    l1 = s.split("}")
    answer = []
    
    for i in range(len(l1)):
        l1[i] = l1[i].replace('{', '')
        l1[i] = l1[i].strip(',')
    l1 = ' '.join(l1).split()
    l2 = [[0]*500 for _ in range(500)] 
    
    for i in range(len(l1)):
        l2[i] = l1[i].split(',')
    for i in range(len(l1)):
        for j in range(len(l2[i])):
            l2[i][j] = int(l2[i][j])
            
    for i in range(1, len(l1)+1):
        for j in l2:
            if len(j) == i:
                for k in j:
                    if k not in answer:
                        answer.append(k)

    return answer