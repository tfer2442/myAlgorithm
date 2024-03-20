import sys
from collections import deque
input = sys.stdin.readline

n, k = map(int, input().split())
belt = list(map(int, input().split()))
robot = [0]*n
cnt = 1
zeroBelt = 0

while True:
    belt.insert(0, belt.pop())
    robot.insert(0, robot.pop())

    if robot[n-1] == 1:
        robot[n-1] = 0

    for i in range(n-2, -1, -1):
        if robot[i] == 1 and robot[i+1] == 0 and belt[i+1] != 0:
            robot[i], robot[i+1] = 0, 1
            belt[i+1] -= 1
            if belt[i+1] == 0:
                zeroBelt += 1

    if robot[n-1] == 1:
        robot[n-1] = 0

    if belt[0] != 0:
        robot[0] = 1
        belt[0] -= 1
        if belt[0] == 0:
            zeroBelt += 1

    if zeroBelt >= k:
        print(cnt)
        break
    cnt += 1

