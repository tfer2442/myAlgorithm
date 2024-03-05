import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
bestFriend = [0] * (n+1)
friend = [0] * (n+1)
friendConnect = []

for i in range(m):
    a, b = map(int, input().split())

    if a == 1:
        bestFriend[b] = 1
    else:
        friendConnect.append((a, b))

for a, b in friendConnect:
    if bestFriend[a] == 1 and bestFriend[b] == 1:
        continue
    if bestFriend[a] == 1:
        friend[b] = 1
    if bestFriend[b] == 1:
        friend[a] = 1

print(friend.count(1) + bestFriend.count(1))
