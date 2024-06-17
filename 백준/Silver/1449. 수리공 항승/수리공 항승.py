import sys
input = sys.stdin.readline

n, l = map(int, input().split())
l *= 10
tmp = list(map(int, input().split()))
tmp.sort()
parts = list()

for i in range(n):
    parts.append(tmp[i]*10)

start = parts[0] - 5
end = start + l
answer = 1

for i in range(n):
    if start <= parts[i] <= end:
        continue
    start = parts[i] - 5
    end = start + l
    answer += 1

print(answer)

