
n = int(input())
l1 = list(map(int, input().split()))
num = int(input())
cnt = 0
for i in l1:
    if i == num:
        cnt += 1
print(cnt)