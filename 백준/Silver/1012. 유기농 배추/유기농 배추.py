import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    M, N, K = map(int, input().split())
    l1 = []

    for i in range(K):
        c, r = map(int, input().split())
        sIndex = []
        for j in range(len(l1)):
            if [r + 1, c] in l1[j]:
                sIndex.append(j)
            elif [r - 1, c] in l1[j]:
                sIndex.append(j)
            elif [r, c + 1] in l1[j]:
                sIndex.append(j)
            elif [r, c - 1] in l1[j]:
                sIndex.append(j)
        if not sIndex:
            l1.append([[r, c]])
        else:
            if len(sIndex) == 1:
                l1[sIndex[0]].append([r, c])
            else:
                for j in range(len(sIndex) - 1, 0, -1):
                    l1[sIndex[j-1]] = l1[sIndex[j]] + l1[sIndex[j-1]]
                    l1[sIndex[j-1]].append([r, c])
                    l1.pop(sIndex[j])
    print(len(l1))
