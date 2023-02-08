T = int(input())
for _ in range(T):
    PR = input()
    ans = 0
    stop = 0
    for pr in PR:
        if pr == '(':
            ans += 1
        else:
            ans -= 1
        if ans < 0:
            stop = 1
            break
    if ans == 0 and stop == 0:
        print('YES')
    else:
        print('NO')