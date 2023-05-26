from collections import deque, Counter

def solution(gems):
    answer = []
    
    d1 = Counter(gems)
    d2 = Counter()
    gemslen = len(d1)
    
    d2[gems[0]] += 1
    left = 0
    right = 0
    
    while True:
        if len(d2) != gemslen:
            right += 1
            if right >= len(gems):
                break
            d2[gems[right]] += 1
        elif len(d2) == gemslen:
            answer.append([left+1, right+1])
            d2[gems[left]] -= 1
            if d2[gems[left]] == 0:
                del d2[gems[left]]
            left += 1
            if left >= len(gems): 
                break
    answer.sort(key = lambda x : (x[1]-x[0]))

    return answer[0]