from collections import Counter
    
def splitToTwoWords(str1):
    l1 = []
    result = []
    
    for i in range(len(str1)-1):
        tmp = str1[i] + str1[i+1]
        l1.append(tmp)
    for word in l1:
        if (word.isalpha()):
            result.append(word)
    return result

def solution(str1, str2):
    l1 = splitToTwoWords(str1.lower())
    l2 = splitToTwoWords(str2.lower())
    dic1 = Counter(l1)
    dic2 = Counter(l2)

    uniNum = len(list((dic1|dic2).elements()))
    diffNum = len(list((dic1&dic2).elements()))
    
    if uniNum == 0:
        return 65536
    return int((diffNum/uniNum) * 65536)


