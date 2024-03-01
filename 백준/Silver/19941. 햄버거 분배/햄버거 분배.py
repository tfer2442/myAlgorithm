import sys
input = sys.stdin.readline

n, k = map(int, input().split())
table = input().strip()
hamburger = list()
people = list()

for i, element in enumerate(table):
    if element == 'H':
        hamburger.append(i)
        continue
    if element == 'P':
        people.append(i)
        continue

cnt = 0
hamburgerIndex = 0
peopleIndex = 0

while hamburgerIndex < len(hamburger) and peopleIndex < len(people):
    if 0 < people[peopleIndex] - hamburger[hamburgerIndex] <= k:
        hamburgerIndex += 1
        peopleIndex += 1
        cnt += 1
        continue

    if k < people[peopleIndex] - hamburger[hamburgerIndex]:
        hamburgerIndex += 1
        continue

    if 0 < hamburger[hamburgerIndex] - people[peopleIndex] <= k:
        hamburgerIndex += 1
        peopleIndex += 1
        cnt += 1
        continue

    if k < hamburger[hamburgerIndex] - people[peopleIndex]:
        peopleIndex += 1
        continue

print(cnt)
