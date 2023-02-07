from collections import deque
import sys
input = sys.stdin.readline

def findChild(node, L):
    i, j = node[0], node[1]
    child = set()
    if i+1 < Nr and L[i+1][j] == 0:
        child.add((i+1, j))
    if i-1 >= 0 and L[i-1][j] == 0:
        child.add((i-1, j))
    if j-1 >= 0 and L[i][j-1] == 0:
        child.add((i, j-1))
    if j+1 < Nc and L[i][j+1] == 0:
        child.add((i, j+1))
    return child

M, N = map(int, input().split())
L = [list(map(int, input().split())) for i in range(N)]
Nr = len(L)
Nc = len(L[0])
queue = deque()
for i in range(Nr):
    for j in range(Nc):
        if L[i][j] == 1:
            queue.append((i,j))

curNodes = set()
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
        L[curNode[0]][curNode[1]] = 1
    
    queue = deque(curNodes)
    day += 1

for l in L:
    if 0 in l:
        day = -1
print(day)
        
    