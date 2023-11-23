def getValidStr(new_id):
    validChar = '-_.'
    temp = ""
    
    for c in new_id:
        if c.isalpha() or c.isdigit() or (c in validChar):
            temp += c
    return temp    


def removeSeqDot(new_id):
    for _ in range(len(new_id)):
        new_id = new_id.replace('..', '.')
    return new_id


def solution(new_id):
    step1Id = new_id.lower()
    step2Id = getValidStr(step1Id)
    step3Id = removeSeqDot(step2Id)
    step4Id = step3Id.strip('.')

    if not step4Id:
        step5Id = 'a'
    else:
        step5Id = step4Id
    
    if len(step5Id) >= 16:
        step6Id = step5Id[:15].strip('.')
    else:
        step6Id = step5Id
    
    if len(step6Id) <= 2:
        step7Id = step6Id + (step6Id[-1] * (3 - len(step6Id)))
    else:
        step7Id = step6Id
                             
    answer = step7Id
    return answer