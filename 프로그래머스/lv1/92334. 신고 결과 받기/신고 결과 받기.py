def solution(id_list, report, k):
    l1 = {}
    l2 = {}
    l3 = {}
    for i in id_list:
        l1[i] = 0
        l2[i] = list()
        l3[i] = 0
    for i in report:
        a, b = i.split()
        if b not in l2[a]:
            l2[a].append(b)
            l1[b] += 1
    
    for i in range(len(id_list)):
        if l1[id_list[i]] >= k:
            for j in id_list:
                if id_list[i] in l2[j]:
                    l3[j] += 1
    answer = []
    for i in range(len(id_list)):
        answer.append(l3[id_list[i]])
         
    return answer