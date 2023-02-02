N, M = map(int, input().split())

L = [input() for i in range(N)]
 
r = 0 # starting point of the row
c = 0 # starting point of the column
        
def cntLine(L: list, row: int, col: int, axis: int, color: str) -> int:
    # axis = 0 -> horizontal, 1 -> vertical
    W = 'WBWBWBWB'
    B = 'BWBWBWBW'
    count = 0
    for i in range(8):
        if axis == 0: 
            if color == 'W':
                if L[row][col+i] != W[i]:
                    count += 1
            elif color == 'B':
                if L[row][col+i] != B[i]:
                    count += 1
        elif axis == 1:
            if color == 'W':
                if L[row+i][col] != W[i]:
                    count += 1
            elif color == 'B':
                if L[row+i][col] != B[i]:
                    count += 1
    return count

def cntAll(L, row, col, color):
    result = 0
    if color == 'W':
        color2 = 'B'
    elif color == 'B':
        color2 = 'W'
    for i in range(8):
        if i%2 == 0:
            result += cntLine(L, row+i, col, 0, color)
        else:
            result += cntLine(L, row+i, col, 0, color2)
    return result

result = 64

for i in range(0, N-7):
    for j in range(0, M-7):
        count = cntAll(L, i, j, 'W')
        if count <= result:
            result = count

for i in range(0, N-7):
    for j in range(0, M-7):
        count = cntAll(L, i, j, 'B')
        if count <= result:
            result = count
            
print(result)

