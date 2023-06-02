def solution(s):
    answer = 0
    minlist = []
    for i in range(1, len(s) // 2 + 1):
        tmps = ""
        cnt = 1

        for j in range(0, len(s), i):
            if s[j:j+i] == s[j+i:j+i+i]:
                cnt += 1           
            else:
                if cnt == 1:
                    tmps += s[j:j+i]
                else:
                    tmps += str(cnt) + s[j:j+i]
                cnt = 1
        minlist.append(len(tmps))
    if minlist:
        answer = min(minlist)
    else:
        answer = len(s)
         
    return answer