import sys
input = sys.stdin.readline

def changeBin(b, c):
    if b == 0 and c == 3:
        return "0000"
    elif b == 1 and c == 3:
        return "0010"

    if b == 0 and c == 4:
        return "0000"
    elif b == 1 and c == 4:
        return "0001"

    cb = ''
    while b > 0:
        cb += str(b % 2)
        b = b // 2

    cb = cb[::-1]

    for i in range(len(cb), c):
        cb = '0' + cb

    if c == 3:
        cb = cb+'0'
    return cb

d1 = {"ADD": "000000", "ADDC": "000010", "SUB": "000100", "SUBC": "000110"
      ,"MOV": "001000", "MOVC": "001010", "AND": "001100", "ANDC": "001110"
    ,"OR": "010000", "ORC": "010010", "NOT": "010100", "MULT": "011000", "MULTC": "011010"
    , "LSFTL": "011100", "LSFTLC": "011110", "LSFTR": "100000", "LSFTRC": "100010", "ASFTR": "100100"
      , "ASFTRC": "100110", "RL": "101000", "RLC": "101010", "RR": "101100", "RRC": "101110"}

n = int(input())

for i in range(n):
    s = input().strip()
    l1 = s.split(' ')
    com = l1[0]
    str1 = ''
    str1 = d1[com] + changeBin(int(l1[1]), 3)[:3] + changeBin(int(l1[2]), 3)[:3]
    if d1[com][4] == '0':
        str1 = str1 + changeBin(int(l1[3]), 3)
    else:
        str1 = str1 + changeBin(int(l1[3]), 4)
    print(str1)

