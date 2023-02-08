N = int(input())

L = [int(input()) for i in range(N)]

L = sorted(L)

for i in range(N):
    print(L[i])