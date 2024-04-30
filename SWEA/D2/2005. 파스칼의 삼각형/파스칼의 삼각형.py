def solution():
    n = int(input())
    
    l1 = [1, 0]
    
    for i in range(n):
        for j in l1:
            if j == 0:
                break
            print(j, end=' ')
        print()
        
        length = len(l1)
        l2 = l1[:]
        for j in range(1, len(l1)):
            l1[j] = l2[j] + l2[j-1]
        l1.append(0)
        

T = int(input())

for t in range(1, T+1):
    print('#%d' %t)
    solution()