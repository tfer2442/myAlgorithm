import sys
input = sys.stdin.readline

def solution(survey, choices):
    result = [[0]*2 for _ in range(4)]
    
    for i in range(len(choices)):
            if survey[i][1] == 'R':
                result[0][0] += choices[i] - 4
            elif survey[i][1] == 'T':
                result[0][1] += choices[i] - 4
            elif survey[i][1] == 'C':
                result[1][0] += choices[i] - 4
            elif survey[i][1] == 'F':
                result[1][1] += choices[i] - 4
            elif survey[i][1] == 'J':
                result[2][0] += choices[i] - 4
            elif survey[i][1] == 'M':
                result[2][1] += choices[i] - 4
            elif survey[i][1] == 'A':
                result[3][0] += choices[i] - 4
            elif survey[i][1] == 'N':
                result[3][1] += choices[i] - 4
  
        


    if result[0][0] >= result[0][1]:
        answer = 'R'
    else:
        answer = 'T'
    
    if result[1][0] >= result[1][1]:
        answer += 'C'
    else:
        answer += 'F'
        
    if result[2][0] >= result[2][1]:
        answer += 'J'
    else:
        answer += 'M'
        
    if result[3][0] >= result[3][1]:
        answer += 'A'
    else:
        answer += 'N'
   
    return answer