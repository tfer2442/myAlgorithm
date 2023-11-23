cnt = 0

def reposeBoard(n, board):
    boardQueue = []
    
    for i in range(n):
        tmp = []
        for j in range(n-1, -1, -1):
            if board[j][i]:
                tmp.append(board[j][i])
        boardQueue.append(tmp)

    return boardQueue


def bomb(item, basket):
    global cnt
    
    if not basket:
        basket.append(item)
        return
    
    if basket[-1] == item:
        basket.pop()
        cnt += 2
        return
    basket.append(item)
    
    
def solution(board, moves):
    answer = 0
    n = len(board)
    boardQueue = reposeBoard(n, board)
    basket = []
    
    for move in moves:
        if boardQueue[move-1]:
            item = boardQueue[move-1].pop()
            bomb(item, basket)
    
    answer = cnt
    
    return answer