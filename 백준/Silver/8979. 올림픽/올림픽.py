import sys
input = sys.stdin.readline

n, k = map(int, input().split())
db = []
medalOfK = (0, 0, 0)

for i in range(n):
    nation, gold, silver, bronze = map(int, input().split())
    db.append((nation, gold, silver, bronze))

    if nation == k:
        medalOfK = (gold, silver, bronze)

db.sort(key=lambda x: (-x[1], -x[2], -x[3]))

for i in range(k):
    if db[i][1:4] == medalOfK:
        print(i+1)
        break

