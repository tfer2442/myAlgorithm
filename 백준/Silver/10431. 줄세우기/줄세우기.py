import sys
input = sys.stdin.readline

p = int(input())

for t in range(p):
    nums = list(map(int, input().split()))
    sortedStudents = [nums[1]]
    total = 0

    for i in range(2, 21):
        #print(total)
        for j in range(i-1, -1, -1):
            if sortedStudents[j-1] < nums[i]:
                total += len(sortedStudents) - j
                sortedStudents.insert(j, nums[i])
                break
        else:
            total += len(sortedStudents)
            sortedStudents.insert(0, nums[i])

    print(t+1, total)

