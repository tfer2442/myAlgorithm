import math

def solution(fees, records):
    l1 = []
    record = []
    d1 = {}
    d2 = {}
    d3 = {}
    answer = []
    for tmp in records:
        record = list(tmp.split(' '))
        th, tm = map(int, record[0].split(':'))
        m = th * 60 + tm
        if record[2] == 'IN':
            l1.append(record[1])
            d1[record[1]] = m
            d2[record[1]] = 1439
        elif record[2] == 'OUT':
            d2[record[1]] = m
            if record[1] in d3: 
                d3[record[1]] += d2[record[1]] - d1[record[1]]
            else:
                d3[record[1]] = d2[record[1]] - d1[record[1]]
            del d1[record[1]]
            del d2[record[1]]
    l1 = list(set(l1))
    for i in d1:
        if i in d3: 
            d3[i] += d2[i] - d1[i]
        else:
            d3[i] = d2[i] - d1[i]
    
    for i in d3:
        if d3[i] <= fees[0]:
            d3[i] = fees[1]
        else:
            d3[i] = fees[1] + math.ceil((d3[i] - fees[0])/fees[2]) * fees[3]
    l1.sort()
    
    for i in l1:
        answer.append(d3[i])
    
    return answer