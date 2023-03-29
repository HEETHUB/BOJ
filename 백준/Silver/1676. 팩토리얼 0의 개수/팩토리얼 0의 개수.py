def facto(N):
    L = [1]*(N+1)
    for i in range(2, N+1):
        L[i] = L[i-1]*i
    return L[N]

N = int(input())
num = str(facto(N))
i = 0
while True:
    if num[-(i+1)] == '0':
        i += 1
    else:
        break
print(i)