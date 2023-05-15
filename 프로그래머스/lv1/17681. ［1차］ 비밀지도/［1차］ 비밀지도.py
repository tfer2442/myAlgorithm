def solution(n, arr1, arr2):
    answer = [[0]*n for _ in range(n)]
    answer2 = []
    cnt = 0
    for i, j in zip(arr1, arr2):
        l1 = []
        l2 = []
        while True:
            if i == 0:
                l1.append(0)
                break
            if i == 1:
                l1.append(1)
                break
            if i % 2 == 1:
                i = i//2
                l1.append(1)
            else:
                i = i//2
                l1.append(0)
                
        lenl = len(l1)
        for _ in range(lenl,n):
            l1.append(0)
            
        while True:
            if j == 0:
                l2.append(0)
                break
            if j == 1:
                l2.append(1)
                break
            if j % 2 == 1:
                j = j//2
                l2.append(1)
            else:
                j = j//2
                l2.append(0)

        lenl = len(l2)
        for _ in range(lenl,n):
            l2.append(0)
            
        for b in range(n-1, -1, -1):
                if (l1[n-b-1] == 1) or (l2[n-b-1] == 1):
                    answer[cnt][b] = '#'
                else:
                    answer[cnt][b] = ' '
        cnt += 1
    
    for i in range(n):
        tmp = ""
        for j in range(n):
            if answer[i][j] == '#':
                tmp += "#"
            else:
                tmp += " "
        answer2.append(tmp)
    return answer2