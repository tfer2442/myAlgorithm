#2차원 배열 만들기, 2차원 배열 크기 구하는 법 알았음.

def solution(maps):
    answer = 0
    r = len(maps)
    c = len(maps[0])
    q = []

    a = 0
    b = 0
    q.append([a, b])

    while True:
        if len(q) == 0:
            return -1
        a, b = q.pop(0)
        #maps[a][b] = 0

        if a+1 != r and maps[a+1][b] == 1 and not(a+1 == 0 and b == 0):
            maps[a+1][b] = maps[a][b] + 1
            q.append([a+1, b])
        if b+1 != c and maps[a][b+1] == 1 and not(a == 0 and b+1 == 0):
            maps[a][b+1] = maps[a][b] + 1
            q.append([a, b+1])
        if a-1 != -1 and maps[a-1][b] == 1 and not(a-1 == 0 and b == 0):
            maps[a-1][b] = maps[a][b] + 1
            q.append([a-1, b])
        if b-1 != -1 and maps[a][b-1] == 1 and not(a == 0 and b-1 == 0):
            maps[a][b-1] = maps[a][b] + 1
            q.append([a, b-1])

        if a == r-1 and b == c-1:
            answer = maps[r-1][c-1]
            break

    return answer