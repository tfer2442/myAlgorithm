def solution(m, n, board):
    answer = 0
    board.append('X'*(n+1))
    b1 = [[0]*(n+1) for _ in range(m+1)]
    
    for i in range(m):
        board[i] = board[i] + 'X'
    
    for i in range(m+1):
        for j in range(n+1):
            b1[i][j] = board[i][j]
    while True:
        for i in range(m):
            for j in range(n):
                if (b1[i][j] != 'X') and (b1[i][j].upper() == b1[i][j+1].upper() == b1[i+1][j].upper() == b1[i+1][j+1].upper()):
                    b1[i][j] = b1[i][j].lower()
                    b1[i][j+1] = b1[i][j+1].lower()
                    b1[i+1][j] = b1[i+1][j].lower()
                    b1[i+1][j+1] = b1[i+1][j+1].lower()
        cnt = 0
        for i in range(m):
            for j in range(n):
                if 'a' <= b1[i][j] <= 'z':
                    cnt += 1
                    b1[i][j] = 'X'
        for k in range(m):
            for i in range(m-2, -1, -1):
                for j in range(n):
                    if b1[i+1][j] == 'X':
                        b1[i+1][j] = b1[i][j]
                        b1[i][j] = 'X'
        
        if cnt == 0:
            break
        answer += cnt
            
                
    return answer