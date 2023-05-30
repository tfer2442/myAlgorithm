def solution(places):
    d = {0: (0, -1), 1: (-1, 0), 2: (0, 1), 3: (1, 0)}
    d2 = {0: (-1, -1), 1: (-1, 1), 2: (1, 1), 3: (1, -1)}
    d3 = {0: (0, -2), 1: (-2, 0), 2: (0, 2), 3: (2, 0)}
    answer = []
    
    for matrix in places:
        flag = 0
        for i in range(5):
            for j in range(5):
                if matrix[i][j] == 'P':
                    for k in range(4):
                        ti = i
                        tj = j
                        ti += d3[k][0]
                        tj += d3[k][1]
                        if (0 <= ti < 5) and (0 <= tj < 5):
                            if matrix[ti][tj] == 'P':
                                if k == 0:
                                    if matrix[i][j-1] == 'O':
                                        answer.append(0)
                                        flag = 1
                                        break
                                elif k == 1:
                                    if matrix[i-1][j] == 'O':
                                        answer.append(0)
                                        flag = 1
                                        break 
                                elif k == 2:
                                    if matrix[i][j+1] == 'O':
                                        answer.append(0)
                                        flag = 1
                                        break
                                elif k == 3:
                                    if matrix[i+1][j] == 'O':
                                        answer.append(0)
                                        flag = 1
                                        break
                    if flag == 1:
                        break
                        
                    for k in range(4):
                        ti = i
                        tj = j
                        ti += d[k][0]
                        tj += d[k][1]
                        if (0 <= ti < 5) and (0 <= tj < 5):
                            if matrix[ti][tj] == 'P':
                                answer.append(0)
                                flag = 1
                                break
                    if flag == 1:
                        break
                        
                    for k in range(4):
                        ti = i
                        tj = j
                        ti += d2[k][0]
                        tj += d2[k][1]
                        if (0 <= ti < 5) and (0 <= tj < 5):
                            if matrix[ti][tj] == 'P':
                                if k == 0:
                                    if (matrix[i][j-1] == 'O') or (matrix[i-1][j] == 'O'):
                                        answer.append(0)
                                        flag = 1
                                        break
                                elif k == 1:
                                    if (matrix[i-1][j] == 'O') or (matrix[i][j+1] == 'O'):
                                        answer.append(0)
                                        flag = 1
                                        break 
                                elif k == 2:
                                    if (matrix[i][j+1] == 'O') or (matrix[i+1][j] == 'O'):
                                        answer.append(0)
                                        flag = 1
                                        break
                                elif k == 3:
                                    if (matrix[i+1][j] == 'O') or (matrix[i][j-1] == 'O'):
                                        answer.append(0)
                                        flag = 1
                                        break
                    if flag == 1:
                        break
            if flag == 1:
                break       
        else:
            answer.append(1)        
             
    return answer