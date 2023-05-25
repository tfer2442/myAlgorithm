def solution(participant, completion):
    answer = ''
    d1 = {}
    for i in participant:
        if i not in d1:
            d1[i] = 1
        else:
            d1[i] += 1
    for i in completion:
        d1[i] -= 1
        if d1[i] == 0:
            del d1[i]
    for i in d1:
        answer = i

    return answer