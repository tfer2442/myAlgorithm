import sys
from itertools import product
input = sys.stdin.readline


def init_board():
    for _ in range(n):
        tmp = list(map(int, input().split()))
        board.append(tmp[:])


def init_directions(k):
    for arr in product([1, 2, 3, 4], repeat=k):
        directions.append(arr[:])


def find_max_value(board2):
    max_value = 0

    for i in range(n):
        max_value = max(max_value, max(board2[i]))
    max_board.append(max_value)


def copy_board(board2):
    for i in range(n):
        for j in range(n):
            board2[i][j] = board[i][j]


def remove_zero(arr):
    zero_count = arr.count(0)
    for _ in range(zero_count):
        arr.remove(0)


def combine_line(arr):
    remove_zero(arr)
    for i in range(len(arr)-1):
        if arr[i] == arr[i+1]:
            arr[i] += arr[i+1]
            arr[i+1] = 0
    remove_zero(arr)

    for i in range(n-len(arr)):
        arr.append(0)

    return arr[:]


def move(com, board2):
    if com == 1:  # 왼쪽
        for i in range(n):
            arr = board2[i][:]
            board2[i] = combine_line(arr)[:]

    elif com == 2:  # 오른쪽
        for i in range(n):
            arr = board2[i][:]
            arr.reverse()
            board2[i] = list(reversed(combine_line(arr)[:]))

    elif com == 3:  # 윗쪽
        for i in range(n):
            arr = []
            for j in range(n):
                arr.append(board2[j][i])
            arr2 = combine_line(arr)[:]
            for j in range(n):
                board2[j][i] = arr2[j]

    elif com == 4:  # 아랫쪽
        for i in range(n):
            arr = []
            for j in range(n):
                arr.append(board2[j][i])
            arr.reverse()
            arr2 = combine_line(arr)[:]
            arr2.reverse()
            for j in range(n):
                board2[j][i] = arr2[j]

def move_board(direction):
    board2 = [[0] * n for _ in range(n)]
    copy_board(board2)

    for com in direction:
        move(com, board2)

    find_max_value(board2)


def input_directions():
    for direction in directions:
        move_board(direction)


n = int(input())
board = []
directions = []
max_board = []


init_board()
init_directions(5)
input_directions()
print(max(max_board))

