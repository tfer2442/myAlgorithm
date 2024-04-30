def solution():
    line = input()

    for i in range(10):
        num = 30 // (i+1)

        if line[:i+1] * num == line[:num * (i+1)]:
            print(i+1)
            break

   
T = int(input())

for t in range(1, T + 1):
    print('#%d' % t, end=' ')
    solution()
