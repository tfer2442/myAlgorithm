def solution(str1, str2):
    str1 = str1.upper() + "."
    str2 = str2.upper() + "."
    l1 = []
    l2 = []
    d1 = {}
    d2 = {}

    for i in range(len(str1) - 1):
        if ('A' <= str1[i] <= 'Z') and ('A' <= str1[i + 1] <= 'Z'):
            tmp = str1[i] + str1[i + 1]
            l1.append(tmp)
    for i in range(len(str2) - 1):
        if ('A' <= str2[i] <= 'Z') and ('A' <= str2[i + 1] <= 'Z'):
            tmp = str2[i] + str2[i + 1]
            l2.append(tmp)

    for i in range(len(l1)):
        if l1[i] in d1:
            d1[l1[i]] += 1
        else:
            d1[l1[i]] = 1
    for i in range(len(l2)):
        if l2[i] in d2:
            d2[l2[i]] += 1
        else:
            d2[l2[i]] = 1
    l1 = list(set(l1))
    l2 = list(set(l2))
    s = 0  # sum
    a = 0  # and
    for i in range(len(l1)):
        if l1[i] in d1 and l1[i] in d2:
            a += min(d2[l1[i]], d1[l1[i]])
            s += max(d2[l1[i]], d1[l1[i]])
            del d1[l1[i]]
            del d2[l1[i]]
        elif l1[i] in d1 and l1[i] not in d2:
            s += d1[l1[i]]
            del d1[l1[i]]
    for i in range(len(l2)):
        if l2[i] in d2 and l2[i] in d1:
            a += min(d2[l2[i]], d1[l2[i]])
            s += max(d2[l2[i]], d1[l2[i]])
            del d1[l2[i]]
            del d2[l2[i]]
        elif l2[i] in d2 and l2[i] not in d1:
            s += d2[l2[i]]
            del d2[l2[i]]
    if s == 0:
        return 65536
    else:
        answer = int((a / s) * 65536)
    return answer

