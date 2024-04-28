def findMaxSumRow():
    maxValue = -999999999
    
    for i in range(100):
        maxValue = max(maxValue, sum(board[i]))
    return maxValue


def findMaxSumCol():
    maxValue = -999999999
    
    for i in range(100):
        sumValue = 0
        for j in range(100):
            sumValue += board[j][i]
        maxValue = max(maxValue, sumValue)
    return maxValue


def findRightCrossSum():
    sumValue = 0
    
    for i in range(100):
        sumValue += board[i][i] 
    return sumValue


def findLeftCrossSum():
    sumValue = 0
    
    for i in range(100):
        sumValue += board[i][100-i-1]
    return sumValue

for i in range(10):
    t = int(input())
    board = []
    
    for i in range(100):
        board.append(list(map(int, input().split())))
    
    print("#%d" %t, max(findMaxSumRow(), findMaxSumCol(), findRightCrossSum(), findLeftCrossSum()))