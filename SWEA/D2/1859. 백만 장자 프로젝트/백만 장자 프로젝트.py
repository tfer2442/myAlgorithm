T = int(input())
from collections import Counter

for i in range(1, T+1):
    n = int(input())
    l1 = list(map(int, input().split()))
    l2 = sorted(l1)
    d1 = Counter(l1)
    subNum = 0
    subPrice = 0
    totalPrice = 0
    
    for num in l1:
        d1[num] -= 1

        if num < l2[-1]:
            subNum += 1
            subPrice += num
            continue
        
        if num == l2[-1]:
            totalPrice += subNum * l2[-1] - subPrice
            subNum = 0
            subPrice = 0
            for j in range(len(l2)-1, -1, -1):
                if d1[l2[j]] > 0:
                    break
                if d1[l2[j]] <= 0:
                    l2.pop()
    print('#%d' %i, totalPrice)
            