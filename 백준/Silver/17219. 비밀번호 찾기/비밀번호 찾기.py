import sys
input = sys.stdin.readline

n, m = map(int, input().split())
passwordDic = {}

for _ in range(n):
    addr, password = input().split()
    passwordDic[addr] = password

for _ in range(m):
    addr = input().strip()
    print(passwordDic[addr])