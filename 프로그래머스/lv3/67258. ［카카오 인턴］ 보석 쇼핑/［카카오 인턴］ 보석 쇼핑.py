from collections import deque
def solution(gems):
    answer = []
    d1 = {}
    gemslen = 0
    s = set()

    for i in gems:
        if i in d1:
            d1[i] += 1
        else:
            d1[i] = 1
            gemslen += 1
            
    left = 0
    right = 0
    de = deque()
    de.appendleft(1)
    s1 = set(de)
    print(s1)
    #for i, j in enumerate(gems):
    #    s.add(j)
       # if len(s) == gemslen:
      #      answer.append([left+1, right+1])
      #      break
        
            
    
    
    return answer