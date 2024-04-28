T = int(input())
d = [[0, 1], [1, 0], [0, -1], [-1, 0]]

def snailMove(totalNum):
    move = [0, 0]
    cnt = 1
    snail[0][0] = cnt
    i = 0
    
    for _ in range(totalNum-1):
        m0, m1 = move[0] + d[i][0], move[1] + d[i][1]
        
        if 0 <= m0 < num and 0 <= m1 < num and snail[m0][m1] == 0:
            move[0], move[1] = m0, m1
            cnt += 1
            snail[move[0]][move[1]] = cnt
            continue
            
        i = (i + 1) % 4
        m0, m1 = move[0] + d[i][0], move[1] + d[i][1]
        move[0], move[1] = m0, m1
        cnt += 1
        snail[move[0]][move[1]] = cnt  
    

for i in range(1, T+1):
    num = int(input())
    snail = [[0]*(num) for _ in range(num)]
    snailMove(num*num)
    
    print('#%d' %i)
    for j in range(num):
        for k in range(num):
            print(snail[j][k], end=' ')
        print()
   