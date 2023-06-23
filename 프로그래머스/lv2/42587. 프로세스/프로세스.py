def solution(priorities, location):
    answer = 0
    l1 = []
    for i in range(len(priorities)):
        l1.append((priorities[i], i))
    l2 = []
        
    while l1:
        tmp = l1.pop(0)
        
        for i in range(len(l1)):
            if l1[i][0] > tmp[0]:
                l1.append(tmp)
                break
        else:
            l2.append(tmp)
    
    for i in range(len(l2)):
        if location == l2[i][1]:
            answer = i + 1
    
    return answer