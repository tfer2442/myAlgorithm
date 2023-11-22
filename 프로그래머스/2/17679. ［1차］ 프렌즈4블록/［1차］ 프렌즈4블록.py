def calBomb(n, m, boardList, bombIndexes):
    for i in range(n-1):
        for j in range(m-1):
            if isBombBlock(boardList, i, j):
                bombIndexes.append((i,j))

                
def bomb(boardList, bombIndexes):
    for index in bombIndexes:
        boardList[index[0]][index[1]] = '!'
        boardList[index[0]+1][index[1]] = '!'
        boardList[index[0]][index[1]+1] = '!'
        boardList[index[0]+1][index[1]+1] = '!'

        
def isBombBlock(board, i, j):
    if board[i][j] == '!':
        return False
    
    if board[i][j] == board[i][j+1] == board[i+1][j] == board[i+1][j+1]:
        return True
    return False

def solution(m, n, board):
    answer = 0
    
    boardList = [[0]*m for _ in range(n)]

    for j in range(n):
        for i in range(m):
            boardList[n-j-1][i] = board[i][j]
    
    while(True):
        bombIndexes = []
        calBomb(n, m, boardList, bombIndexes)
        
        if not bombIndexes:
            break
        
        bomb(boardList, bombIndexes)
    
        for i in range(n):
            tmp = ''.join(boardList[i])
            tmp = tmp.replace('!', '')
            tmp = tmp.rjust(m, '!')
            boardList[i] = list(tmp[:])
            
    
    for i in range(n):
        for j in range(m):
            if not boardList[i][j].isalpha():
                answer += 1
                
    return answer