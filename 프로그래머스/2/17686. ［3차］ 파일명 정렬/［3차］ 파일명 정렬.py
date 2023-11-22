splitedFile = []

def splitFile(index, file):
    head = ""
    number = ""
    tail = ""
    tailIndex = 0
    flag = False
    
    for i, s in enumerate(file):
        if s.isdigit():
            flag = True
            number += s
        elif flag == False:
            head += s
        elif flag == True:
            tailIndex = i
            break
    
    if tailIndex == 0:
        splitedFile.append([head.upper(), int(number), tail, index])
    else:
        splitedFile.append([head.upper(), int(number), file[tailIndex:], index])

        
        
def solution(files):
    answer = []
    sortingIndex = []
    
    for i, file in enumerate(files):
        splitFile(i, file)
    splitedFile.sort(key = lambda x : (x[0], x[1]))
    
    for i in range(len(splitedFile)):
        answer.append(files[splitedFile[i][3]])
    
    return answer