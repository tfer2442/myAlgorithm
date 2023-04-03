import sys
input = sys.stdin.readline
sys.setrecursionlimit(10 ** 6)


def recursive_star(n):
    if n == 3:
        return ['***', '* *', '***']

    l1 = recursive_star(n//3)
    star = []

    for i in l1:
        star.append(i*3)
    for i in l1:
        star.append(i+' '*(n//3)+i)
    for i in l1:
        star.append(i*3)

    return star


n = int(input())
star = recursive_star(n)
for i in range(n):
    print(star[i])
