def findNeighbor(L: list) -> dict:
    N = len(L)
    dr = [0, 0, 1, -1]
    dc = [1, -1, 0, 0]
    graph = {}
    for i in range(len(L)):
        for j in range(len(L[0])):
            if L[i][j] == 0:
                continue
            graph[(i, j)] = []
            if i+1 < N and L[i+1][j] == 0:
                graph[(i,j)].append([i+1, j])
            if i-1 >= 0 and L[i-1][j] == 0:
                graph[(i,j)].append([i-1, j])
            if j-1 >= 0 and L[i][j-1] == 0:
                graph[(i,j)].append([i, j-1])
            if j+1 < N and L[i][j+1] == 0:
                graph[(i,j)].append([i, j+1])
            
    return graph

# import sys 
# input = sys.stdin.readline
M, N = map(int, input().split())
L = [list(map(int, input().split())) for i in range(N)]
graph = findNeighbor(L)
day = 0
print(L)
while graph:
    day += 1
    for parent in graph:
        for child in graph[parent]:
            L[child[0]][child[1]] = 1
    print(L)
    graph = findNeighbor(farm)
    print(graph)
    
ans = 1
for l in L:
    if 0 in l:
        ans = -1
if ans == 1:
    print(day)
else:
    print(-1)
