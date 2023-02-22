def solution(numbers, hand):
    answer = ''
    l = [3, 0]
    r = [3, 2]
    dic = {1:[0,0], 2:[0,1], 3:[0,2], 4:[1,0], 5:[1,1], 6:[1,2], 7:[2,0], 8:[2,1],
          9:[2,2], 0:[3,1]}
    for i in numbers:
        if i == 1 or i == 4 or i == 7:
            answer += 'L'
            l[0] = dic[i][0]
            l[1] = dic[i][1]
        elif i == 3 or i == 6 or i == 9:
            answer += 'R'
            r[0] = dic[i][0]
            r[1] = dic[i][1]
        else:
            a = abs(dic[i][0] - l[0]) + abs(dic[i][1] - l[1])    
            b = abs(dic[i][0] - r[0]) + abs(dic[i][1] - r[1])
            if a < b:
                answer += 'L'
                l[0] = dic[i][0]
                l[1] = dic[i][1]
            elif a > b:
                answer += 'R'
                r[0] = dic[i][0]
                r[1] = dic[i][1]
            else:
                if hand == 'left':
                    answer += 'L'
                    l[0] = dic[i][0]
                    l[1] = dic[i][1]
                else:
                    answer += 'R'
                    r[0] = dic[i][0]
                    r[1] = dic[i][1]
    return answer