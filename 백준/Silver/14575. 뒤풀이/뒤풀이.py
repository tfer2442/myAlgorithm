import sys
input = sys.stdin.readline

N, T = map(int, input().split())

L = []
R = []

for i in range(N):
    tmp1, tmp2 = map(int, input().split())
    L.append(tmp1)
    R.append(tmp2)

s = max(L)
lsum = sum(L)
rsum = sum(R)
left = s
right = T
soju_sum = 0

mid = (s + T) // 2
if lsum <= T <= rsum: # 기분이 다 좋아야 하기 때문에 T가 Lsum보다 커야함. 술을 다 마시긴 해야 하므로 Rsum보다는 작야아 함.
    while True:
        soju_sum = 0
        for i in range(N):
            if L[i] <= mid <= R[i]:
                soju_sum += mid
            else:
                soju_sum += R[i]

        if soju_sum >= T:
            right = mid
            mid = (left + right) // 2
        elif soju_sum < T:
            if left == mid:
                print(mid+1)
                break
            left = mid
            mid = (left + right) // 2

        if left == right:
            print(mid)
            break
else:
    print(-1)

