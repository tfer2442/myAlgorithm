from itertools import combinations

T = int(input())

for t in range(1, T+1):
    n, b = map(int, input().split())
    people = list(map(int, input().split()))
    result = sum(people) - b

    for i in range(1, n+1):
        for heights in combinations(people, i):
            total = sum(heights)
            if total < b:
                continue

            result = min(result, total-b)
    print('#%d' % t, result)
