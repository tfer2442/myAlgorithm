import sys
input = sys.stdin.readline

n, d = map(int, input().split())
shortcut = {}

for _ in range(n):
    start, end, distance = map(int, input().split())

    if distance >= end - start:
        continue
    if end > d:
        continue

    if (start, end) in shortcut:
        shortcut[(start, end)] = min(shortcut[(start, end)], distance)
    else:
        shortcut[(start, end)] = distance

tmpPoint = set()

for (start, end) in shortcut:
    tmpPoint.add(start)
    tmpPoint.add(end)

tmpPoint.add(0)
tmpPoint.add(d)

point = list(tmpPoint)
point.sort()
minLen = [999999999] * len(point)
minLen[0] = 0

for i in range(1, len(point)):
    distCollections = []

    for j in range(0, i):
        a, b = point[j], point[i]
        if (a, b) in shortcut:
            distCollections.append(minLen[j] + shortcut[(a, b)])

    distCollections.append(minLen[i-1] + point[i] - point[i-1])
    minLen[i] = min(distCollections)
    
print(minLen[-1])

