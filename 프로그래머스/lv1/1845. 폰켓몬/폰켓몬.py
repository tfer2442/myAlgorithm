def solution(nums):
    lnum = len(nums) // 2
    snums = len(set(nums))
    
    if snums >= lnum:
        answer = lnum
    else:
        answer = snums
        
    return answer