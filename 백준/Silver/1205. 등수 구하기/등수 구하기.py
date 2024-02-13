import sys
input = sys.stdin.readline

# 0 <= n <= p, 10 <= p <= 50, 0 <= taesu <= 2_000_000_000
def play():
    if n == 0:
        print(1)
        return
    scores = list(map(int, input().split()))
    rank = 0

    for i, score in enumerate(scores):
        if score <= taesu:
            scores.insert(i, taesu)
            rank = i
            break
    else:
        if p == n:
            print(-1)
            return
        if p != n:
            print(len(scores) + 1)
            return

    if p == n:
        if scores[-1] == taesu:
            print(-1)
            return

    print(rank+1)


n, taesu, p = map(int, input().split())
play()
