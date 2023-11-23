def calDistance(left, right, num):
    lD = abs(left[0] - num[0]) + abs(left[1] - num[1])
    rD = abs(right[0] - num[0]) + abs(right[1] - num[1])
    
    return lD, rD


def getHandOfCenterNumber(ld, rD, hand):
    if ld > rD:
        return 'R'
    if ld < rD:
        return 'L'
    
    if hand == 'right':
        return 'R'
    if hand == 'left':
        return 'L'


def solution(numbers, hand):
    handOfNum = {1: 'L', 4: 'L', 7: 'L', 3: 'R', 6: 'R', 9: 'R'}
    numLocation = {1: (0, 0), 2: (0, 1), 3: (0, 2), 
                   4: (1, 0), 5: (1, 1), 6: (1, 2), 
                   7: (2, 0), 8: (2, 1), 9: (2, 2), 0: (3, 1)}
    left = (3, 0)
    right = (3, 2)
    
    result = ""
    
    for num in numbers:
        if num in handOfNum:
            result += handOfNum[num]
            if handOfNum[num] == 'R':
                right = numLocation[num]
            else:
                left = numLocation[num]
        else:
            lD, rD = calDistance(left, right, numLocation[num])
            pressedHand = getHandOfCenterNumber(lD, rD, hand)
            if pressedHand == 'R':
                right = numLocation[num]
            else:
                left = numLocation[num]
            result += pressedHand   
                
    return result