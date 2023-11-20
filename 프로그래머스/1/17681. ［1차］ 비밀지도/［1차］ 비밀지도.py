def fillZero(n, str):
    return ((n - len(str)) * '0') + str 
        

def del0b(n, num):
    result = str(bin(num)).replace('0b','')
    result = fillZero(n, result)
    return result

def replaceMap(n, str1, str2):
    result = ""
    for i in range(n):
        if str1[i] == '1' or str2[i] == '1':
            result += '#'
        else:
            result += ' '
    return result
    

def solution(n, arr1, arr2):
    result = []
    for i in range(n):
        str1 = del0b(n, arr1[i])
        str2 = del0b(n, arr2[i])
        result.append(replaceMap(n, str1, str2))
    
    return result