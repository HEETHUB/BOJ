def star(N):
    if N == 3:
        return ['***','* *','***']
    result = []
    div = N//3
    n = star(div)
    s = [' '*div]*div
    x = list(zip(n, n, n))
    y = list(zip(n, s, n))
    for i in range(len(x)):
        x[i] = ''.join(x[i])
    for i in range(len(y)):
        y[i] = ''.join(y[i])
    return x+y+x

N = int(input())
ans = '\n'.join(star(N))
print(ans)