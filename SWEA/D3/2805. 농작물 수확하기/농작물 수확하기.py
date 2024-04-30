def solution():
    n = int(input())
    board = []
    
    for i in range(n):
        board.append(input())
    
    start = n//2
    num = 1
    nums = ""
    for i in range(n):
        nums += board[i][start:start+num]
        
        if (i+1) > n//2:
            start += 1
            num -= 2
        else:
            start -= 1
            num += 2
    
    total = 0
    for i in range(len(nums)):
        total += int(nums[i])
        
    print(total)

    
T = int(input())

for t in range(1, T+1):
    print('#%d' %t, end =' ')
    solution()