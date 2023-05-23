def solution(files):
    d1 = {}
    cnt = 0
    l1 = []
    answer = []
    
    for i in range(len(files)):
        s1 = ""
        s2 = ""
        s3 = ""
        k = 0
        j = 0
        l = 0
        for j in range(len(files[i])):
            if (('A' <= files[i][j] <= 'Z') or ('a' <= files[i][j] <= 'z') or (files[i][j] == ' ') or (files[i][j] == '.') or (files[i][j] == '-')):
                s1 += files[i][j]
                k = j
            else:
                k = j
                break
        for j in range(k, len(files[i])):
            if (('0' <= files[i][j] <= '9')):
                s2 += files[i][j]
                l = j
            else:
                l = j
                break
        for j in range(l, len(files[i])):
            s3 += files[i][j]
            
        s2 = int(s2)
        if s3:
            l1.append((s1.upper(), s2, s3.upper(), cnt))
        else:
            l1.append((s1.upper(), s2, '', cnt))

        d1[cnt] = files[i]
        cnt += 1

    l1.sort(key = lambda x : (x[0], x[1]))
    
    for i in range(len(l1)):
        answer.append(d1[l1[i][3]])
    print(int('001'))
    return answer