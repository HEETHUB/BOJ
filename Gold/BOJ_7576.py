# import sys 
# input = sys.stdin.readline
M, N = map(int, input().split())
farm = [list(map(int, input().split())) for i in range(N)]
graph = findNeighbor(farm)
day = 0

while graph:
    day += 1
    for parent in graph:
        for child in parent:
            i = child[0]
            j = child[1]
            L[i][j] = 1
    graph = findNeighbor(farm)
    
ans = 1
for l in L:
    if 0 in l:
        ans = -1
if ans == 1:
    print(day)
else:
    print(-1)
