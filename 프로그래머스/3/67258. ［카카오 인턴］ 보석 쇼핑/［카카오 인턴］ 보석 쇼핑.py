from collections import Counter, deque


def solution(gems):
    answer = []
    allGems = Counter(gems)
    gemTypeNum = len(allGems)
    basket = Counter()
    start = 0
    basket[gems[start]] = 1
    i = 1
    
    if gemTypeNum == 1:
        return [1, 1]
        
    while True:
        if len(basket) == gemTypeNum:
            answer.append([start+1, i])
            basket[gems[start]] -= 1
            if basket[gems[start]] == 0:
                del basket[gems[start]]
            start += 1
            continue
        if i >= len(gems):
            break
            
        if gems[start] == gems[i]:
            start += 1
        else:
            basket[gems[i]] += 1
        i += 1    
          
        
    answer.sort(key = lambda x : ((x[1]-x[0]), x[0]))
    
    return answer[0]
