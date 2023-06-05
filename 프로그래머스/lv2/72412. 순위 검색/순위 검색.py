from itertools import combinations
from collections import defaultdict
from bisect import bisect_left

def solution(info, query):
    l1 = []
    l2 = []
    answer = []
    d1 = defaultdict(list)
    
    for i in range(len(info)):
        l1 = list(info[i].split(' '))
        l1[-1] = int(l1[-1])
        
        for j in range(5):
            for k in combinations(l1[:4], j):
                str1 = ''.join(k)  
                d1[str1].append(l1[-1])
    
    for i in d1:
        d1[i].sort()
        
    for i in range(len(query)):
        l2 = list(query[i].replace('and ', '').split(' '))
        l2[-1] = int(l2[-1])
        str1 = ''
        for j in range(len(l2)-1):
            if l2[j] != '-':
                str1+=l2[j]
                
        if str1 in d1:
            # left = 0
            # right = len(d1[str1])-1
            # result = len(d1[str1])
            idx = bisect_left(d1[str1], l2[4])
            answer.append(len(d1[str1]) - idx)
            
#             while left <= right:
#                 mid = (left+right) // 2

#                 if d1[str1][mid] < l2[4]:
#                     left = mid + 1
#                 else:
#                     result = mid
#                     right = mid - 1
#             answer.append(len(d1[str1]) - result)
        else:
            answer.append(0)
            
    return answer