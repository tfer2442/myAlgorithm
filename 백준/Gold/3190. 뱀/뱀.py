import sys
from collections import deque

input = sys.stdin.readline


def init_map():
    for i in range(1, n+1):
        for j in range(1, n+1):
            dummy_map[i][j] = 0
    dummy_map[1][1] = 3  # 뱀 처음 위치


def init_apple():
    for i in range(k):
        r, c = map(int, input().split())
        dummy_map[r][c] = 2


def input_snake_information():
    L = int(input())

    for i in range(L):
        num, angle = input().split()
        command.append([int(num), angle])

    for i in range(L-1, 0, -1):
        command[i][0] -= command[i-1][0]
    command.append([10000, 'S'])


def move_snake():
    count_gg = 0
    cur_direction = 0

    for i in range(len(command)):
        dir_r, dir_c = direction[cur_direction]

        for j in range(command[i][0]):
            count_gg += 1
            head_r, head_c = snake.pop()
            snake.append((head_r, head_c))

            arrive_r = head_r + dir_r
            arrive_c = head_c + dir_c

            if dummy_map[arrive_r][arrive_c] == 1 or dummy_map[arrive_r][arrive_c] == 3:
                print(count_gg)
                return

            if dummy_map[arrive_r][arrive_c] == 0:
                tail_r, tail_c = snake.popleft()
                dummy_map[tail_r][tail_c] = 0

            snake.append((arrive_r, arrive_c))
            dummy_map[arrive_r][arrive_c] = 3

        if command[i][1] == 'D':
            cur_direction += 1
            if cur_direction > 3:
                cur_direction = 0

        elif command[i][1] == 'L':
            cur_direction -= 1
            if cur_direction < 0:
                cur_direction = 3
    print(count_gg)


n = int(input())
k = int(input())

dummy_map = [[1] * (n+2) for _ in range(n+2)]
snake = deque()
command = []
direction = [(0, 1), (1, 0), (0, -1), (-1, 0)]

init_map()
init_apple()
snake.append((1, 1))
input_snake_information()
move_snake()


