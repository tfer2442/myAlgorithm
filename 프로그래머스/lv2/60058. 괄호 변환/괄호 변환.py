import sys
sys.setrecursionlimit(10**7)

def div(s):
    left = 0
    right = 0
    u = ''
    v = ''

    for i in range(len(s)):
        if s[i] == '(':
            left += 1
        else:
            right += 1
        if left == right:   
            u = s[0:i+1]
            v = s[i+1:len(s)]
            break
    
    return u, v
 
def correct(s):
    left = 0
    right = 0
    flag = 0
    for i in range(len(s)):
        if s[i] == '(':
            left += 1
        else:
            right += 1
        if right > left: # 올바른 문자열이 아닐 때
            return False
            break
    return True
    
    
def f(s):
    if not s:
        return ''
    u, v = div(s)
    flag = correct(u)
    if flag: # 올바른 문자열 일 때
        u += f(v)
        return u
        
        
    if not flag:
        tmp = '('
        tmp += f(v)
        tmp += ')'
        u = u[1:(len(u)-1)]
        change = ''
        for i in range(len(u)):
            if u[i] == '(':
                change += ')'
            else:
                change += '('
        tmp = tmp + change
    return tmp
            
            
def solution(p):
    
    return f(p)