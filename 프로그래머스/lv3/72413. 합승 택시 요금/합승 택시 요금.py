def solution(n, s, a, b, fares):
    answer = 0
    INF = 999999
    ansList = []
    matrix = [[INF]*(n+1) for i in range(n+1)]
    D = [[0]*(n+1) for i in range(n+1)]
    for i in range(1, n+1):
        matrix[i][i] = 0
    for t1, t2, t3 in fares:
        matrix[t1][t2] = t3
        matrix[t2][t1] = t3
        
    for i in range(n+1):
        for j in range(n+1):
            D[i][j] = matrix[i][j]    

    for k in range(1, n+1):
        for i in range(1, n+1):
            for j in range(1, n+1):
                D[i][j] = min(D[i][k] + D[k][j], D[i][j])
    
    for i in range(1, n+1):
        ansList.append(D[s][i] + D[i][a] + D[i][b])
    
    answer = min(ansList)
    
    return answer