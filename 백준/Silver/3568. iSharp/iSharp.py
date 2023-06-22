import sys

input = sys.stdin.readline

s = input().strip()
l1 = s.split(',')  # ,로 분리해서 변수 몇 개 인지 보기

vartype = l1[0].split(' ')[0]
l1[0] = ' ' + l1[0].split(' ')[1]
l2 = list()

for i in range(len(l1)):
    tmp = ''
    tvar = ''
    for j in l1[i]:
        if j == ";":
            break
        if j.isalpha():
            tmp += j
        else:
            if j == '[':
                tvar += ']'
            elif j == ']':
                tvar += '['
            else:
                tvar += j
    l2.append(vartype + tvar[::-1] + tmp + ';')

for i in l2:
    print(i)
