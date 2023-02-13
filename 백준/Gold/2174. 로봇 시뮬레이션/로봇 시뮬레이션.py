import sys
input = sys.stdin.readline


def robot_exist(n, choice, r, c):
    for i in range(1, n+1):
        if robot[i][0] == r and robot[i][1] == c:
            print("Robot %d crashes into robot %d"%(choice, i))
            return True
    return False


a, b = map(int, input().split())
n, m = map(int, input().split())
robot = [[0]]
com = [0, 0, 0]
d = {'W': (-1, 0), 'N': (0, 1), 'E': (1, 0), 'S': (0, -1)}
bp = False

for i in range(1, n+1):
    robot.append(input().split())
    robot[i][0] = int(robot[i][0])
    robot[i][1] = int(robot[i][1])
    #robot[i][2] = d[robot[i][2]]

for i in range(m):
    com[0], com[1], com[2] = input().split()
    com[0] = int(com[0]) # 로봇 선택
    com[2] = int(com[2]) # 반복 횟수

    for j in range(com[2]):
       if com[1] == 'F':
           if robot[com[0]][2] == 'W':
               if robot[com[0]][0] + d['W'][0] <= 0:
                   print("Robot %d crashes into the wall"%com[0])
                   exit(0)
                   break
               elif robot_exist(n, com[0], robot[com[0]][0] + d['W'][0], robot[com[0]][1]):
                   exit(0)
                   break
               robot[com[0]][0] = robot[com[0]][0] + d['W'][0]
           elif robot[com[0]][2] == 'N':
               if robot[com[0]][1] + d['N'][1] > b:
                   print("Robot %d crashes into the wall"%com[0])
                   exit(0)
                   break
               elif robot_exist(n, com[0], robot[com[0]][0], robot[com[0]][1] + d['N'][1]):
                   exit(0)
                   break
               robot[com[0]][1] = robot[com[0]][1] + d['N'][1]
           elif robot[com[0]][2] == 'E':
               if robot[com[0]][0] + d['E'][0] > a:
                   print("Robot %d crashes into the wall"%com[0])
                   exit(0)
                   break
               elif robot_exist(n, com[0], robot[com[0]][0] + d['E'][0], robot[com[0]][1]):
                   exit(0)
                   break
               robot[com[0]][0] = robot[com[0]][0] + d['E'][0]
           elif robot[com[0]][2] == 'S':
               if robot[com[0]][1] + d['S'][1] <= 0:
                   print("Robot %d crashes into the wall"%com[0])
                   exit(0)
                   break
               elif robot_exist(n, com[0], robot[com[0]][0], robot[com[0]][1] + d['S'][1]):
                   exit(0)
                   break
               robot[com[0]][1] = robot[com[0]][1] + d['S'][1]
       elif com[1] == 'R':
           if robot[com[0]][2] == 'W':
               robot[com[0]][2] = 'N'
           elif robot[com[0]][2] == 'N':
               robot[com[0]][2] = 'E'
           elif robot[com[0]][2] == 'E':
               robot[com[0]][2] = 'S'
           elif robot[com[0]][2] == 'S':
               robot[com[0]][2] = 'W'
       elif com[1] == 'L':
           if robot[com[0]][2] == 'W':
               robot[com[0]][2] = 'S'
           elif robot[com[0]][2] == 'N':
               robot[com[0]][2] = 'W'
           elif robot[com[0]][2] == 'E':
               robot[com[0]][2] = 'N'
           elif robot[com[0]][2] == 'S':
               robot[com[0]][2] = 'E'
print('OK')