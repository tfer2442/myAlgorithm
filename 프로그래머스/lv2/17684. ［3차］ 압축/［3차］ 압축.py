def solution(msg):
    answer = []
    d = {}
    for i in range(26):
        d[chr(ord('A')+i)] = i+1
        
    msg = msg + '0'
    s = ""
    prev = ""
    cnt = 27
    
    for i in range(len(msg)):
        s += msg[i]
        
        if s not in d:
            d[s] = cnt
            cnt += 1
            answer.append(d[prev])
            s = msg[i]
            prev = ""
        prev = s
            
    return answer