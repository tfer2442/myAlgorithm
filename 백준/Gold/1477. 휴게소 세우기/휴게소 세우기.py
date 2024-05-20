import sys
input = sys.stdin.readline

n, m, l = map(int, input().split())
shelter = [0] + [l] + list(map(int, input().split()))
shelter.sort()

left = 1
right = l
answer = float('inf')
while left <= right:
    mid = (left+right)//2

    result = 0
    for i in range(n+1):
        result += (shelter[i + 1] - shelter[i]) // mid
        if (shelter[i+1]-shelter[i]) % mid == 0:
            result -= 1

    if result <= m:
        answer = min(answer, mid)
        right = mid - 1
    else:
        left = mid + 1

print(answer)
