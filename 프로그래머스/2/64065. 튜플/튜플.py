def solution(s):
    s = s[2:len(s)-2]
    
    l1 = s.split('},{')
    l1.sort(key = lambda x : len(x))
    
    l2 = []
    
    for nums in l1:
        nums = map(int, nums.split(','))
        for num in nums:
            if num not in l2:
                l2.append(num)
                break

    return l2
 