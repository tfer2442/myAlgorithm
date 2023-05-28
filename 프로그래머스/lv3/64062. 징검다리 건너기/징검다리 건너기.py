import sys
sys.setrecursionlimit(10 ** 7)
def solution(stones, k):
    #     answer = 0
    #     l2 = []
    #     for i in range(len(stones)-k+1):
    #         l1 = []
    #         for j in range(i, i+k):

    #             heappush(l1, -stones[j])
    #         heappush(l2, -heappop(l1))
    #     answer = l2[0]
    answer = 0
    ans = []
    l1 = sorted(stones)

    def f(m):
        cnt = 0
        for i in stones:
            if i - m <= 0:
                cnt += 1
            else:
                cnt = 0
            if cnt == k:
                ans.append(m)
                return False
        return True
    
    left = 0
    right = len(stones)-1
    while True:
        if left > right:
            break
        mid = (left + right) // 2
        flag = f(l1[mid])
        if flag:
            left = mid+1
        else:
            right = mid-1
            
    if ans:
        answer = min(ans)
    else:
        answer = stones[0]

    return answer