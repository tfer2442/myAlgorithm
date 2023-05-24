def solution(board):
    answer = 0
    d1 = {0: (-1, 0), 1: (0, 1), 2: (1, 0), 3: (0, -1)}

    maxr = len(board)
    maxc = len(board[0])
    flag = 0
    visited = [[0]*maxc for _ in range(maxr)]
    for i in range(maxr):
        for j in range(maxc):
            if board[i][j] == 'R':
                sr, sc = i, j
                flag = 1
                break
        if flag == 1: break

    q = []
    q.append((sr, sc, 1))
    visited[sr][sc] = 1
    while True:
        if not q:
            break

        a, b, cnt = q.pop(0)

        for i in d1:
            tmpa = a
            tmpb = b

            while True:
                c, d = tmpa + d1[i][0], tmpb + d1[i][1]

                if (0 <= c < maxr) and (0 <= d < maxc):
                    if board[c][d] != 'D':
                        tmpa, tmpb = c, d
                    else:
                        if board[tmpa][tmpb] == 'G':
                            return cnt
                        break
                else:
                    if board[tmpa][tmpb] == 'G':
                        return cnt
                    break
            if (a != tmpa) or (b != tmpb):
                if visited[tmpa][tmpb] == 1:
                    continue
                visited[tmpa][tmpb] = 1
                q.append((tmpa, tmpb, cnt + 1))

    return -1


print(solution([".D.R", "....", ".G..", "...D"]))