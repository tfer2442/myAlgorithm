import math
import sys
input = sys.stdin.readline

N = int(input())
testPlace = list(map(int, input().split()))
B, C = map(int, input().split())
totalTeacher = len(testPlace)

for i in range(N):
    testPlace[i] -= B

    if testPlace[i] <= 0:
        continue
    totalTeacher += math.ceil(testPlace[i]/C)

print(totalTeacher)