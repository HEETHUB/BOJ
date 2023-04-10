N = int(input())
L = [0]*(N+1)
for i in range(2, N+1):
    if i <= 3:
        L[i]= 1
    L[i] = L[i-1]+1
    if not i%2:
        L[i] = min(L[i], L[i//2]+1)
    if not i%3:
        L[i] = min(L[i], L[i//3]+1)
print(L[N])