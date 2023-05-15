from heapq import heappush, heappop

def solution(N, stages):
    answer = []
    s = len(stages)
    l1 = [0]*(N+2)
    l2 = []
    for i in stages:
        l1[i] += 1
    for i in range(1, len(l1)-1):
        if s <= 0:
            for j in range(i, len(l1)-1):
                heappush(l2, (0, j))
            break
        per = l1[i]/s
        heappush(l2, (-per, i))
        s -= l1[i]
        
    for i in range(N):
        a, b = heappop(l2)
        answer.append(b)


    return answer