def solution(survey, choices):
    answer = ''
    rt = 0
    cf = 0
    jm = 0
    an = 0
    
    for i in range(len(survey)):
        if survey[i] == 'AN':
            an += 4 - choices[i]
        elif survey[i] == 'NA':
            an += choices[i] - 4
        elif survey[i] == 'CF':
            cf += 4 - choices[i]
        elif survey[i] == 'FC':
            cf += choices[i] - 4
        elif survey[i] == 'JM':
            jm += 4 - choices[i]
        elif survey[i] == 'MJ':
            jm += choices[i] - 4
        elif survey[i] == 'RT':
            rt += 4 - choices[i]
        elif survey[i] == 'TR':
            rt += choices[i] - 4
    
    if rt >= 0:
        answer += 'R'
    else:
        answer += 'T'
    
    if cf >= 0:
        answer += 'C'
    else:
        answer += 'F'
    
    if jm >= 0:
        answer += 'J'
    else:
        answer += 'M'
    
    if an >= 0:
        answer += 'A'
    else:
        answer += 'N'
    return answer