import sys
input = sys.stdin.readline

f, s, g, u, d = map(int, input().split())
count1 = 0
check = [0] * 1000001
while True:
    if check[s] == 1:
        print("use the stairs")
        break
    check[s] = 1

    if g > s:
        if u == 0:
            print("use the stairs")
            break
        if s + u > f:
            if s - d < 1:
                print("use the stairs")
                break
            s = s - d
            count1 += 1
            continue
        s = s + u
        count1 += 1
    elif g < s:
        if d == 0:
            print("use the stairs")
            break
        if s - d < 1:
            if s + u > f:
                print("use the stairs")
                break
            s = s + u
            count1 += 1
            continue
        s = s - d
        count1 += 1
    else:
        print(count1)
        break
