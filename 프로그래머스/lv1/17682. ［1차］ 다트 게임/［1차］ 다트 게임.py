def solution(dartResult):
    l1 = [[0] * 3 for _ in range(3)]
    l2 = [0] * 4
    j = 0
    k = 0
    answer = 0
    ten = False
    for i in range(len(dartResult)):
        if ten == True:
            ten = False
            continue
            
        if '2' <= dartResult[i] <= '9':
            l1[j][k] = int(dartResult[i])
            k += 1
        elif dartResult[i] == '1':
            if dartResult[i+1] == '0':
                l1[j][k] = 10
                k += 1
                ten=True
                continue
            else:
                l1[j][k] = 1
                k += 1
        elif dartResult[i] == '0':
            l1[j][k] = 0
            k += 1
        else:
            l1[j][k] = dartResult[i]
            k += 1    
            if (i != len(dartResult)-1) and ('0'<=dartResult[i+1]<='9'):
                j = j+1
                k = 0
    
    for i in range(3):
        l2[i+1] = l1[i][0]
        if l1[i][1] == 'D':
            l2[i+1] = l2[i+1] * l2[i+1]
        elif l1[i][1] == 'T':
            l2[i+1] = l2[i+1] * l2[i+1] * l2[i+1]
        
        if l1[i][2] == '*':
            l2[i+1] = l2[i+1] * 2
            l2[i] = l2[i] * 2
        elif l1[i][2] == '#':
            l2[i+1] = -l2[i+1]
    answer = sum(l2)
            
    return answer