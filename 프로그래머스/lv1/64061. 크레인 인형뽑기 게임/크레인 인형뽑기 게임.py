def solution(board, moves):
    s = []
    answer = 0
    for i in moves:
        for j in range(len(board)):
            if board[j][i-1] != 0:
                if not s:
                    s.append(board[j][i-1])
                else:
                    if s[-1] != board[j][i-1]:
                        s.append(board[j][i-1])
                    else:
                        answer += 2
                        s.pop()
                board[j][i-1] = 0
                break
                    
    return answer