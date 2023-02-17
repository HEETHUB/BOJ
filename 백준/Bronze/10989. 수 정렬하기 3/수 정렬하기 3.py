import sys

N = int(sys.stdin.readline())

L = [0] * 10001

for i in range(N):
    L[int(sys.stdin.readline())] += 1
    
i = 0
while i < 10001:
    if L[i]:
        print(i)
        L[i] -= 1
    else:
        i += 1
