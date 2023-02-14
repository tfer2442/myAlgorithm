from collections import deque
# 그래프 만드는 법 복습!!
def solution(n, computers):
    l1 = [[] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if i != j and computers[i][j]:
                l1[i].append(j)
    q = deque()
    visited = [False] * n
    answer = 0
    
    for j in range(n):
        if visited[j]:
            continue
        q.append(j)
        visited[j] = True
        answer = answer+1
        while True:
            if not q:
                break
            a = q.popleft()
            for i in l1[a]:
                if not visited[i]:
                    q.append(i)
                    visited[i] = True
    return answer