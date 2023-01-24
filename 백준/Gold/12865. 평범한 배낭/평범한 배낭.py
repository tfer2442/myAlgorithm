n, k = map(int, input().split())

w, v = [], []

for _ in range(n):
    a, b = map(int, input().split())
    w.append(a)
    v.append(b)

l1 = [[0] * (k+1) for i in range(n)]

if w[0] <= k:
    l1[0][w[0]] = v[0]

for i in range(1, n):
    for j in range(k, -1, -1):
        l1[i][j] = l1[i-1][j]

        if w[i] <= k and j == 0:
            l1[i][w[i]] = v[i]
        if j + w[i] <= k and l1[i-1][j] != 0:
            l1[i][j+w[i]] = max(l1[i-1][j+w[i]], l1[i-1][j]+v[i])

print(max(l1[n-1]))
