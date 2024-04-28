for test_case in range(1, 11):
    n = int(input())
    buildings = list(map(int, input().split()))
    total = 0
    
    for i in range(2, n-2):
        leftB = min(buildings[i] - buildings[i-1], buildings[i] - buildings[i-2])
        if leftB <= 0:
            continue
        
        rightB = min(buildings[i] - buildings[i+1], buildings[i] - buildings[i+2])
        if rightB <= 0:
            continue
        total += min(leftB, rightB)
        
    print("#%d" %test_case, total)