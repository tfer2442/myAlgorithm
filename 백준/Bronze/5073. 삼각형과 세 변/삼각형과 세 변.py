import sys
input = sys.stdin.readline

while True:
    triangle = list(map(int, input().split()))

    if triangle[0]*triangle[1]*triangle[2] == 0:
        break
    triangle.sort(reverse=True)
    a, b, c = triangle[:]

    if b + c <= a:
        print("Invalid")
        continue

    if a == b == c:
        print("Equilateral")
        continue

    if a != b and b != c and a != c:
        print("Scalene")
        continue

    if (a == b and b != c) or (a != b and b == c):
        print("Isosceles")
        continue
