N = int(input())
ans = 0
# col : column, diag1 : right-down diagonal, diag2 : left-down diagonal
col, diag1, diag2 = [True]*N, [True]*(2*N-1), [True]*(2*N-1)

def dfs(r):
    global ans
    if r == N:
        ans += 1
        return
    for c in range(N):
        # check if (r, c) is available
        if col[c] and diag1[r+c] and diag2[r-c+(N-1)]:
            col[c] = diag1[r+c] = diag2[(N-1)+r-c] = False
            # increase a depth(=r)
            dfs(r+1)
            # make (r, c) unvisited for next loop
            col[c] = diag1[r+c] = diag2[(N-1)+r-c] = True

# start from depth(=r) = 0            
for c in range(N):
    col[c] = diag1[c] = diag2[(N-1)-c] = False
    dfs(1)
    col[c] = diag1[c] = diag2[(N-1)-c] = True
print(ans)
