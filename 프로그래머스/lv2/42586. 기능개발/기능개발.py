def solution(progresses, speeds):
    answer = []

    cnt = 0
    while progresses:
        for i in range(len(progresses)):
            progresses[i] = progresses[i] + speeds[i]

        if progresses[0] >= 100:
            # if len(progresses) == 1:
            #     progresses.pop(0)
            #     speeds.pop(0)
            #     answer.append(1)

            for j in range(len(progresses)):
                if progresses[j] < 100:
                    for k in range(j):
                        progresses.pop(0)
                        speeds.pop(0)
                    answer.append(j)
                    break
            else:
                for k in range(j+1):
                    progresses.pop(0)
                    speeds.pop(0)
                answer.append(j+1)

    return answer