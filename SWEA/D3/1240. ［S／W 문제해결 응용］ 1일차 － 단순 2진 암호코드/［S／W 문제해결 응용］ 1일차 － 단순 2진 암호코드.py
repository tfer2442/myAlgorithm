# import sys
# from collections import deque
# input = sys.stdin.readline
#
#
# def solution():
#     n, k = map(int, input().split())
#     l1 = list(map(int, input().split()))
#     graph = [{} for _ in range(n+1)]
#
#     for i in range(k):
#         x, y = map(int, input().split())
#         graph[y][x] = True
#     w = int(input())
#     distance = [-1] * (n+1)
#     distance[w] = l1[w-1]
#
#     d = deque()
#     d.append(w)
#
#     while d:
#         node = d.popleft()
#
#         for v in graph[node]:
#             if distance[v] == -1 or distance[v] < distance[node]+l1[v-1]:
#                 distance[v] = l1[v-1] + distance[node]
#                 d.append(v)
#
#     print(max(distance))
#
#
# T = int(input())
#
# for t in range(T):
#     solution()

def decode(num):
    if num == "0001101":
        return "0"
    if num == "0011001":
        return "1"
    if num == "0010011":
        return "2"
    if num == "0111101":
        return "3"
    if num == "0100011":
        return "4"
    if num == "0110001":
        return "5"
    if num == "0101111":
        return "6"
    if num == "0111011":
        return "7"
    if num == "0110111":
        return "8"
    if num == "0001011":
        return "9"


def solution():
    n, m = map(int, input().split())

    codes = ""

    for i in range(n):
        line = input()
        if int(line) != 0:
            line = line.rstrip('0')
            codes = line[len(line) - 56:]
            continue

    decodeLine = []
    for i in range(8):        
        decodeLine.append(decode(codes[i*7:i*7+7]))

    oddSum = 0
    evenSum = 0

    for i in range(1, 9):
        if i % 2 == 0:
            evenSum += int(decodeLine[i-1])
            continue
        oddSum += int(decodeLine[i-1])

    if (oddSum * 3 + evenSum) % 10 == 0:
        print(oddSum+evenSum)
    else:
        print(0)


T = int(input())

for t in range(1, T + 1):
    print('#%d' % t, end=' ')
    solution()