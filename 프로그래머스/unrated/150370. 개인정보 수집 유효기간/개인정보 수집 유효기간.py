def solution(today, terms, privacies):
    term = {}
    answer = []
    
    for tmp in terms:
        a, b = tmp.split()
        b = int(b)
        term[a] = b
        
    ty, tm, td = today.split('.')
    ty = int(ty)
    tm = int(tm)
    td = int(td)
    
    for i in range(len(privacies)):
        a, b = privacies[i].split()
        y, m, d = a.split('.')
        
        y = int(y)
        m = int(m)
        d = int(d)
        
        if (term[b] + m) == 12:
            m = 12
        elif (term[b] + m) % 12 == 0:
            y = y + (term[b]+ m) // 12 - 1
            m = 12
        else:
            y = y + (term[b]+ m) // 12
            m = (term[b] + m) % 12
    

        
        if y < ty:
            answer.append(i+1)
        elif y == ty:
            if m < tm:
                answer.append(i+1)
            elif m == tm:
                if d <= td:
                    answer.append(i+1)           
    
    return answer