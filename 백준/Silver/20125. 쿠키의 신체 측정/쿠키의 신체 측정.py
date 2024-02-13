import sys
input = sys.stdin.readline


def findHeadAndHeart():
    for i in range(n):
        for j in range(n):
            if square[i][j] == '*':
                head = (i, j)
                heart = (i + 1, j)
                return head, heart


def findLeftHandLen():
    leftHandLen = 0

    for i in range(heart[1]-1, -1, -1):
        if square[heart[0]][i] == '*':
            leftHandLen += 1
        else:
            return leftHandLen
    return leftHandLen


def findRightHandLen():
    rightHandLen = 0

    for i in range(heart[1]+1, n):
        if square[heart[0]][i] == '*':
            rightHandLen += 1
        else:
            return rightHandLen
    return rightHandLen


def findWaistPositionAndLen():
    waistLen = 0

    for i in range(heart[0]+1, n):
        if square[i][heart[1]] == '*':
            waistLen += 1
        else:
            return i-1, waistLen


def findLeftLegLen():
    leftLegLen = 0

    for i in range(waistPosition[0]+1, n):
        if square[i][waistPosition[1]-1] == '*':
            leftLegLen += 1
        else:
            return leftLegLen
    return leftLegLen


def findRightLegLen():
    rightLegLen = 0

    for i in range(waistPosition[0]+1, n):
        if square[i][waistPosition[1]+1] == '*':
            rightLegLen += 1
        else:
            return rightLegLen
    return rightLegLen


n = int(input())
square = []

for _ in range(n):
    tmp = list(input().strip())
    square.append(tmp)

head, heart = findHeadAndHeart()
leftHandLen = findLeftHandLen()
rightHandLen = findRightHandLen()
waistRow, waistLen = findWaistPositionAndLen()
waistPosition = (waistRow, heart[1])
leftLegLen = findLeftLegLen()
rightLegLen = findRightLegLen()

print(heart[0]+1, heart[1]+1)
print(leftHandLen, rightHandLen, waistLen, leftLegLen, rightLegLen)

