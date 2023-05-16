def solution(new_id):
    l1 = ''
    l2 = ''

    for i in new_id:
        l1 += i
        
    l1 = l1.lower()
            
    for c in l1:
        if c in "~!@#$%^&*()=+[{]}:?,<>/":
            l1 = l1.replace(c, '')
            
    for i in range(len(new_id)):
        l1 = l1.replace('..', '.')
    
    l1 = l1.strip('.')
    if not l1:
        l1 = "a"
    
    if len(l1) >= 16:
        for i in range(15):
            l2 += l1[i]
    else:
        for i in l1:
            l2 += i    
    l2 = l2.rstrip('.')
    
    if len(l2) <=2:
        tmp = l2[len(l2)-1]
        for i in range(len(l2), 3):
            l2 += tmp
    
    return l2