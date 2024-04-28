
def sumBugs(r, c, m):
    global maxValue
    sumValue = 0
    
    for i in range(r, r+m):
        for j in range(c, c+m):
            sumValue += l1[i][j]
    maxValue = max(maxValue, sumValue)


T = int(input())

for t in range(1, T+1):
    n, m = map(int, input().split())
    l1 = []
    maxValue = 0
    
    for i in range(n):
        l1.append(list(map(int, input().split())))
    
    
    for i in range(n-m+1):
        for j in range(n-m+1):
            sumBugs(i, j, m)
    print("#%d" % t, maxValue)
   