from collections import deque
import sys
input = sys.stdin.readline

def findChild(node, L):
    f, i, j = node[0], node[1], node[2]
    child = set()
    if i+1 < Nr and L[f][i+1][j] == 0:
        child.add((f, i+1, j))
    if i-1 >= 0 and L[f][i-1][j] == 0:
        child.add((f, i-1, j))
    if j-1 >= 0 and L[f][i][j-1] == 0:
        child.add((f, i, j-1))
    if j+1 < Nc and L[f][i][j+1] == 0:
        child.add((f, i, j+1))
    if f-1 >= 0 and L[f-1][i][j] == 0:
        child.add((f-1, i, j))    
    if f+1 < Nf and L[f+1][i][j] == 0:
        child.add((f+1, i, j))
    return child

M, N, H = map(int, input().split())
L = [list(list(map(int, input().split())) for i in range(N)) for j in range(H)]
Nf = len(L)
Nr = len(L[0])
Nc = len(L[0][0])
# print(L)
queue = deque()
for i in range(Nf):
    for j in range(Nr):
        for k in range(Nc):
            if L[i][j][k] == 1:
                queue.append((i,j,k))

day = -1
while queue:
#     print("day : "+str(day))
    curNodes = set()
    for _ in range(len(list(queue))):
        node = queue.pop()
#         print(node)
        curNodes.update(findChild(node, L))
#     print(curNodes)
    for curNode in curNodes:
        L[curNode[0]][curNode[1]][curNode[2]] = 1
    
    queue = deque(curNodes)
    day += 1

for l in L:
    for ll in l:
        if 0 in ll:
            day = -1
print(day)
        
    