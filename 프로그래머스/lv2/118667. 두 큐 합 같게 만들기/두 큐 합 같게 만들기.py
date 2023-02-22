from collections import deque

def solution(queue1, queue2):
    sq1 = sum(queue1)
    sq2 = sum(queue2)
    cnt = 0
    queue1 = deque(queue1)
    queue2 = deque(queue2)
    
    if (sq1 + sq2)%2 == 1:
        return -1
    
    while True:
        if not queue1 or not queue2:
            return -1
        if sq1 <= 0 or sq2 <= 0:
            return -1
        if cnt >= 600000:
            return -1
        if sq2 > sq1:
            tmp = queue2.popleft()
            queue1.append(tmp)
            sq1 = sq1 + tmp
            sq2 = sq2 - tmp           
        elif sq2 < sq1:
            tmp = queue1.popleft()
            queue2.append(tmp)
            sq1 = sq1 - tmp
            sq2 = sq2 + tmp
        else:
            break
        cnt = cnt + 1
        
        
    answer = cnt
    return answer