import sys
input = sys.stdin.readline


def input_board():
    for i in range(N):
        tmp = list(map(int, input().split()))
        board.append(tmp)


def is_all_same(i, j, L):
    for k in range(j-L+1, j):
        if board[i][k] != board[i][k+1]:
            return False

    for k in range(j-L+1, j+1):
        if visited[i][k]:
            return False

    for k in range(j-L+1, j+1):
        visited[i][k] = True

    return True


def is_all_same2(i, j, L):
    for k in range(j+1, j+L):
        if board[i][k] != board[i][k+1]:
            return False

    for k in range(j+1, j+L+1):
        if visited[i][k]:
            return False

    for k in range(j+1, j+L+1):
        visited[i][k] = True

    return True


def is_all_same3(j, i, L):
    for k in range(j-L+1, j):
        if board[k][i] != board[k+1][i]:
            return False

    for k in range(j-L+1, j+1):
        if visited[k][i]:
            return False

    for k in range(j-L+1, j+1):
        visited[k][i] = True

    return True


def is_all_same4(j, i, L):
    for k in range(j+1, j+L):
        if board[k][i] != board[k+1][i]:
            return False

    for k in range(j+1, j+L+1):
        if visited[k][i]:
            return False

    for k in range(j+1, j+L+1):
        visited[k][i] = True

    return True


def init_visited():
    for i in range(N):
        for j in range(N):
            visited[i][j] = False


def find_way_board():
    count_way = 0

    #  행 탐색
    for i in range(N):
        for j in range(N-1):
            if board[i][j] == board[i][j+1] - 1:
                if j - L + 1 < 0:
                    break
                if not is_all_same(i, j, L):
                    break
            elif board[i][j] == board[i][j+1] + 1:
                if j + L >= N:
                    break
                if not is_all_same2(i, j, L):
                    break
            elif board[i][j] == board[i][j+1]:
                pass
            else:
                break
        else:
            count_way += 1

    init_visited()

    #  열 탐색
    for i in range(N):
        for j in range(N - 1):
            if board[j][i] == board[j+1][i] - 1:
                if j - L + 1 < 0:
                    break
                if not is_all_same3(j, i, L):
                    break
            elif board[j][i] == board[j+1][i] + 1:
                if j + L >= N:
                    break
                if not is_all_same4(j, i, L):
                    break
            elif board[j][i] == board[j+1][i]:
                pass
            else:
                break
        else:
            count_way += 1
    print(count_way)


N, L = map(int, input().split())
board = []
visited = [[False]*N for _ in range(N)]
input_board()
find_way_board()

