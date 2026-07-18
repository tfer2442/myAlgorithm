def calculate(N, K, nums):
    start = N - K
    if start <= 0:
        return 0

    end = N - 1
    cur = start
    cnt = 0

    while True:
        if cur > end:
            return 0

        if nums[cur] == 1:
            cnt += 1
            end = start - 1
            cur = cur - K
            start = cur
            if cur <= 0:
                break
        else:
            cur += 1

    return cnt


T = int(input())

for t in range(1, T + 1):
    K, N, M = map(int, input().split())

    nums = [0] * N
    stops = list(map(int, input().split()))
    for i in range(M):
        nums[stops[i]] = 1

    answer = calculate(N, K, nums)
    print(f"#{t} {answer}")