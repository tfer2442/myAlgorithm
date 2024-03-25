import sys
input = sys.stdin.readline

g = int(input())
squares = [0, 1]

if g == 1:
    print(-1)
    exit(0)

i = 2
while True:
    squares.append(i**2)
    if squares[i] - squares[i-1] >= g:
        break
    i += 1

left = 1
answer = []
sub = 0

for right in range(2, len(squares)):
    while right > left:
        sub = squares[right] - squares[left]
        if sub <= g:
            break

        if sub > g:
            left += 1
            continue

    if sub == g:
        answer.append(right)

if answer:
    print(*answer, sep='\n')
else:
    print(-1)
