import copy

def pp(l1, n, m):
    count = 1

    while(True):
        if (max(l1) == l1[0] and m == 0):
            return count

        if(m == 0):
            m = len(l1) - 1
            l1.append(l1[0])
            l1.pop(0)
            continue

        if l1[0] == max(l1):
            l1.pop(0)
            count = count + 1
            m = m - 1
        else:
            l1.append(l1[0])
            l1.pop(0)
            m = m - 1

T = int(input())

for i in range(T):
    l1 = []
    n, m = map(int, input().split())

    l1 = list(map(int, input().split()))
    print(pp(l1, n, m))