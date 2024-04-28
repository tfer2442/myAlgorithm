def dfs(num):
    global maxValue
    
    if num == cnt:
        maxValue = max(maxValue, int(''.join(nums)))
        return
    
    for i in range(len(nums)-1):
        for j in range(i+1, len(nums)):
            nums[i], nums[j] = nums[j], nums[i]
            
            if (num, int(''.join(nums))) not in visited:
                visited[(num, int(''.join(nums)))] = True
                dfs(num+1)
                
            nums[i], nums[j] = nums[j], nums[i]
            


T = int(input())

for i in range(1, T+1):
    num, cnt = map(int, input().split())
    nums = list(str(num))
    maxValue = -1
    visited = {}
    dfs(0)
    print('#%d' %i, maxValue)
    

    