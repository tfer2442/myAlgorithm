from collections import deque

def solution(stones, k):
    answer = float('inf')
    dq = deque()
    max_values = []

    for i in range(len(stones)):
        # 슬라이딩 윈도우 크기를 유지하기 위해 dq에서 벗어난 인덱스 제거
        if dq and dq[0] == i - k:
            dq.popleft()

        # 현재 원소보다 작은 값들은 dq에서 제거
        while dq and stones[i] >= stones[dq[-1]]:
            dq.pop()

        dq.append(i)
        
        # 현재 슬라이딩 윈도우 내의 최댓값을 max_values에 저장
        if i >= k - 1:
            max_values.append(stones[dq[0]])

    answer = min(max_values)
    return answer