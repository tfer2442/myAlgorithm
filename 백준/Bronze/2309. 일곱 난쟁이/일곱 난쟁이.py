import sys
input = sys.stdin.readline


kids = []
for i in range(9):
    kids.append(int(input()))

kids.sort()
heightTotal = sum(kids)
left = 0
right = 8

while left < right:
    total = heightTotal - kids[left] - kids[right]

    if total == 100:
        for i in range(9):
            if i == left or i == right:
                continue
            print(kids[i])
        break

    if total > 100:
        left += 1
        continue

    if total < 100:
        right -= 1
        continue
