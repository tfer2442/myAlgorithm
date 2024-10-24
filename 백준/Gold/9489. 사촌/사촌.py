from collections import deque

def main():
    while True:
        # 입력 받기
        n, k = map(int, input().split())
        
        if n == 0 and k == 0:
            break

        if n == 1 or n == 2:
            _ = list(map(int, input().split()))  # 입력만 받고 사용하지 않음
            print(0)
            continue

        # 그래프 초기화
        inGraph = {}
        outGraph = {}
        dq = deque()

        # 첫 번째 입력 받기
        nums = list(map(int, input().split()))
        dq.append(nums[0])
        cur = nums[1]
        dq.append(cur)

        parent = dq.popleft()
        prev = cur

        # 그래프 구성
        outGraph[parent] = [prev]
        inGraph[prev] = parent

        for i in range(2, n):
            cur = nums[i]
            dq.append(cur)

            if cur - 1 != prev:
                parent = dq.popleft()

            if parent not in outGraph:
                outGraph[parent] = []

            outGraph[parent].append(cur)
            inGraph[cur] = parent

            prev = cur

        if k not in inGraph or inGraph[k] not in inGraph:
            print(0)
            continue

        # BFS를 사용하여 탐색
        kParent = inGraph[k]
        start = inGraph[kParent]
        dq2 = deque([[start, 0]])
        cnt = 0

        visited = set()

        while dq2:
            curParent = dq2.popleft()

            if curParent[0] in visited:
                continue  # 이미 방문한 노드라면 넘어감

            # 현재 노드를 방문했다고 기록
            visited.add(curParent[0])

            if curParent[1] == 2:
                cnt += 1
                continue

            if curParent[0] not in outGraph:
                continue

            for child in outGraph[curParent[0]]:
                if child == kParent:
                    continue

                dq2.append([child, curParent[1] + 1])

        print(cnt)


if __name__ == "__main__":
    main()