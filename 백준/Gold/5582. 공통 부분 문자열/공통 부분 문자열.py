import sys
input = sys.stdin.readline
 
A = input().rstrip()
B = input().rstrip()
 
result = 0
arr = [[0]*(len(B)+1) for _ in range(len(A)+1)]
for i in range(1, len(A)+1):
    for j in range(1, len(B)+1):
        if A[i-1] == B[j-1]:
            arr[i][j] = arr[i-1][j-1] + 1
            result = max(arr[i][j], result)
 
print(result)