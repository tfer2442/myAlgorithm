import sys
input = sys.stdin.readline


n = int(input())
cards = list(map(int, input().split()))
maxCard = max(cards)
eratostenes = {card: 0 for card in cards}

for card in cards:
    for i in range(card*2, maxCard+1, card):
        if i in eratostenes:
            eratostenes[card] += 1
            eratostenes[i] -= 1

for card in cards:
    print(eratostenes[card], end=' ')
    