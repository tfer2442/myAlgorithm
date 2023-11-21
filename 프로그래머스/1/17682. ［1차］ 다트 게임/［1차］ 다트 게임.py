def getNums(dartResult):
    tmp = ""
    l1 = []
    
    for c in dartResult:
        if c.isdigit():
            tmp += c
        else:
            if tmp == "":
                continue
            l1.append(int(tmp))
            tmp = ""
            
    return l1

def getZone(dartResult):
    l1 = []
    
    for c in dartResult:
        if c.isalpha():
            l1.append(c)
    return l1

def getBouns(dartResult):
    l1 = [False, False, False]
    cnt = -1
    
    for i, c in enumerate(dartResult):
        if c.isalpha():
            cnt += 1
            if dartResult[i+1] == '#' or dartResult[i+1] == '*':
                l1[cnt] = dartResult[i+1]
    
    return l1


def dupBonus(bonus):
    for i in range(len(bonus)):
        if i != 0 and bonus[i] == '*':
            if bonus[i-1] == False:
                bonus[i-1] = '*'
            else:
                bonus[i-1] += '*'

            
def calZone(num, zone):
    if zone == 'S':
        return num
    if zone == 'D':
        return num**2
    if zone == 'T':
        return num**3
    

def calBonus(num, bonus):
    if bonus == False:
        return num
    
    for b in bonus:
        if b == '*':
            num = num * 2
        elif b == '#':
            num = -num
    return num
    

def solution(dartResult):
    answer = 0
    nums = getNums(dartResult)
    zone = getZone(dartResult)
    bonus = getBouns(dartResult+'_')
    dupBonus(bonus)
    
    for i in range(len(nums)):
        nums[i] = calZone(nums[i], zone[i])
        nums[i] = calBonus(nums[i], bonus[i])
        
    answer = sum(nums)
    
    return answer