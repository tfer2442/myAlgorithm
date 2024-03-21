import sys
input = sys.stdin.readline

while True:
    n, a, b = map(int, input().split())

    if n == 0 and a == 0 and b == 0:
        break
    l1 = []
    totalDistance = 0
    for _ in range(n):
        l1.append(list(map(int, input().split())))

    l1.sort(key=lambda x: (x[1]-x[2]))

    for i, node in enumerate(l1):
        if node[1] - node[2] > 0:
            break
        if node[0] == 0:
            continue
        if a >= node[0]:
            a -= node[0]
            totalDistance += node[0] * node[1]
            l1[i] = [0, node[1], node[2]]
        else:
            totalDistance += a * node[1]
            l1[i] = [node[0]-a, node[1], node[2]]
            a = 0

    l1.sort(key=lambda x: (x[2]-x[1]))

    for i, node in enumerate(l1):
        if node[2] - node[1] > 0:
            break
        if node[0] == 0:
            continue
        if b >= node[0]:
            b -= node[0]
            totalDistance += node[0] * node[2]
            l1[i] = [0, node[1], node[2]]
        else:
            totalDistance += b * node[2]
            l1[i] = [node[0]-b, node[1], node[2]]
            b = 0

    if a == 0:
        for i, node in enumerate(l1):
            if node[0] == 0:
                continue
            if b >= node[0]:
                b -= node[0]
                totalDistance += node[0] * node[2]
                l1[i] = [0, node[1], node[2]]
            else:
                totalDistance += b * node[2]
                l1[i] = [node[0] - b, node[1], node[2]]
                b = 0
    elif b == 0:
        for i, node in enumerate(l1):
            if node[0] == 0:
                continue
            if a >= node[0]:
                a -= node[0]
                totalDistance += node[0] * node[1]
                l1[i] = [0, node[1], node[2]]
            else:
                totalDistance += a * node[1]
                l1[i] = [node[0] - a, node[1], node[2]]
                a = 0
    print(totalDistance)