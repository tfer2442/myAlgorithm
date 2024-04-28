def checkRow():
    for i in range(n):
        if len(set(puzzle[i])) != n:
            return False
    return True


def checkCol():
    for i in range(n):
        checked = set()
        for j in range(n):
            checked.add(puzzle[j][i])
            
        if len(checked) != n:
            return False
   
    return True


def checkNine():
    row = 0
    col = 0
    for i in range(n):
        checked = set()
        for j in range(row, row+3):
            for k in range(col, col+3):
                checked.add(puzzle[j][k])
        if len(checked) !=n :
            return False
        
        if col + 3 == n:
            col = 0
            row = row + 3
    return True

T = int(input())
n = 9

for t in range(1, T+1):
    puzzle = []
    
    for i in range(n):
        puzzle.append(list(map(int, input().split())))
    
    print('#%d' %t, end = ' ')
    if checkRow() and checkCol() and checkNine():
        print(1)
        continue
    print(0)