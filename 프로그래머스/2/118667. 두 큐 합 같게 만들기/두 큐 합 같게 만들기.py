from collections import deque


def calPopAndInsert(q1, q2):
    iterNum = max(len(q1), len(q2))
    q1.append(q2.popleft())
    q1Sum = sum(q1)
    q2Sum = sum(q2)

    
    for i in range(1, iterNum*4+2):
        if q1Sum == q2Sum:
            return i
        elif q1Sum > q2Sum:
            item = q1.popleft()
            q2.append(item)
            q1Sum -= item
            q2Sum += item
        elif q1Sum < q2Sum:
            item = q2.popleft()
            q1.append(item)
            q2Sum -= item
            q1Sum += item
    return -1        

            
    
    
def solution(queue1, queue2):
    q1 = deque(queue1)
    q2 = deque(queue2)
    if sum(q1) == sum(q2):
        return 0
    result1 = calPopAndInsert(q1, q2)
    
    q1 = deque(queue1)
    q2 = deque(queue2)
    result2 = calPopAndInsert(q2, q1)
    
    #print(result1, result2)
    answer = min(result1, result2)
    return answer