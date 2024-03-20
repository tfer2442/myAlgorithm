import sys
input = sys.stdin.readline

n = int(input())
tree1 = {}

for i in range(n):
    tree1[chr(65+i)] = []

for _ in range(n):
    a, b, c = input().strip().split()
    tree1[a].extend([b, c])


def preorder(vertex):
    resultOfpreorder.append(vertex)
    if tree1[vertex][0] != '.':
        preorder(tree1[vertex][0])
    if tree1[vertex][1] != '.':
        preorder(tree1[vertex][1])


def inorder(vertex):
    if tree1[vertex][0] != '.':
        inorder(tree1[vertex][0])
    resultOfinorder.append(vertex)
    if tree1[vertex][1] != '.':
        inorder(tree1[vertex][1])


def postorder(vertex):
    if tree1[vertex][0] != '.':
        postorder(tree1[vertex][0])
    if tree1[vertex][1] != '.':
        postorder(tree1[vertex][1])
    resultOfpostorder.append(vertex)


resultOfpreorder = []
preorder('A')

resultOfinorder = []
inorder('A')

resultOfpostorder = []
postorder('A')

print(*resultOfpreorder, sep='')
print(*resultOfinorder, sep='')
print(*resultOfpostorder, sep='')