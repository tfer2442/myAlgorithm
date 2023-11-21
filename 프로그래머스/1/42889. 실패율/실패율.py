def calculateFailRate(stageNum, stages):
    arriveNum = 0
    failNum = 0
    
    for num in stages:
        if stageNum <= num:
            arriveNum += 1
        if stageNum == num:
            failNum += 1
            
    if arriveNum == 0:
        return (0, stageNum)
    
    return (failNum/arriveNum, stageNum)
    

def solution(N, stages):
    answer = []
    failRate = []

    for i in range(N):
        failRate.append(calculateFailRate(i+1, stages))

    failRate.sort(key = lambda x:(-x[0], x[1]))
    
    for i in range(N):
        answer.append(failRate[i][1])
    
    return answer

# 실패율: 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수