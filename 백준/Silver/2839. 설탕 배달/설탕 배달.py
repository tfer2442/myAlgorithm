n = int(input())
count1 = 0
while True:
    if n == 0:
        break
    if n < 2:
        count1 = -1
        break

    if n % 5 == 0:
        count1 += n//5
        break
    n = n - 3
    count1 += 1

print(count1)