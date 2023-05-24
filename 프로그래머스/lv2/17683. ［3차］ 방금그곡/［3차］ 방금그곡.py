import math

def solution(m, musicinfos):
    l1 = []
    answer = '(None)'
    mlen = len(m) - m.count("#")
    for i in range(len(musicinfos)):
        tmp = list(musicinfos[i].split(','))
        h2, m2 = map(int, tmp[1].split(':')) 
        h1, m1 = map(int, tmp[0].split(':'))
        
        if (h2 == 0) and (m2 == 0):
            if h1 == 0:
                h1 = 24
            h2 = 24
        t = (h2 * 60 + m2) - (h1 * 60 + m1)

        if t < mlen:
            continue
        if len(m) <= len(tmp[3]):
            l1.append((t, tmp[2], tmp[3]+tmp[3][0:len(m)-1]))
        elif len(m) > len(tmp[3]):
            mul = int(math.ceil((len(m) / len(tmp[3]))))
            l1.append((t, tmp[2], tmp[3]*(mul+1)))

    l1.sort(key = lambda x : -x[0])
    print(l1)
    for i in range(len(l1)):
        for j in range(len(l1[i][2])):
            cnt = 0
            for k in range(len(m)):
                if l1[i][0] + cnt < k + j - 3:
                    break
                if len(l1[i][2]) > k+j:
                    if m[k] == l1[i][2][k+j]:
                        if l1[i][2][k+j] == '#': cnt += 1 
                        pass
                    else:
                        break
            else:
                if len(l1[i][2]) > (len(m) + j):
                    if l1[i][2][len(m)+j] != '#':
                        answer = l1[i][1]
                        return answer
                elif len(l1[i][2]) == (len(m) + j):
                    answer = l1[i][1]
                    return answer
                    
    return answer