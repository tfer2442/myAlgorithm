from collections import Counter

n = int(input())

for i in range(1, n+1):
    d = Counter(str(i))
    clap = d['3'] + d['6'] + d['9']
    
    if clap == 0:
        print(i, end=' ')
        continue
    print(clap*"-", end=' ')