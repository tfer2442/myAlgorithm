def solution(s):
    lc = 0
    rc = 0
    
    for i in range(len(s)):
        if rc > lc:
            return False
        
        if s[i] == '(':
            lc += 1
        elif s[i] == ')':
            rc += 1
    if lc == rc:
        return True
    return False