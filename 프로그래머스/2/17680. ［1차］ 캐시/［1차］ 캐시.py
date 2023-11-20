def solution(cacheSize, cities):
    missRunTime = 5
    hitRunTime = 1
    totalRunTime = 0
    cache = []
    
    if cacheSize == 0:
        return len(cities) * missRunTime
    
    for city in cities:
        city = city.lower()
        if city in cache:
            totalRunTime += hitRunTime
            cache.remove(city)
            cache.append(city)
        else:
            totalRunTime += missRunTime
            if (len(cache) >= cacheSize):
                cache.pop(0)
            cache.append(city)
    return totalRunTime
