def solution(s):
    pcount = 0
    ycount = 0
    for i in s:
        if i == 'p' or i == 'P':
            pcount += 1
        if i == 'y' or i == 'Y':
            ycount += 1
    print(pcount, ycount)
    if pcount != ycount:
        return False
    return True