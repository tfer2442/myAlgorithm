from collections import Counter

T = int(input())

for _ in range(T):
    tn = int(input())
    l1 = list(map(int, input().split()))
    d1 = Counter(l1)
    maxValue = -9999
    maxScore = -9999
    # 10 8 7 2 2 4 8 8 8 9 5 5 3
    for i in d1:
        if maxValue < d1[i]:
            maxValue = d1[i]
            maxScore = i
            continue
        
        if maxValue == d1[i]:
            maxScore = max(maxScore, i)
            
    print('#%d' % tn, maxScore)