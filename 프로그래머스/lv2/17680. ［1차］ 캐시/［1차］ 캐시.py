def solution(cacheSize, cities):
    l1 = []
    answer = 0
    for i in range(len(cities)):
        cities[i] = cities[i].lower()
        
    for i in range(len(cities)):
        if len(l1) > cacheSize:
            l1.pop(-1)
        if cities[i] in l1:
            tmp = l1.index(cities[i])
            l1.pop(tmp)
            l1.insert(0, cities[i])
            answer += 1
        else:
            l1.insert(0, cities[i])
            answer += 5

    return answer