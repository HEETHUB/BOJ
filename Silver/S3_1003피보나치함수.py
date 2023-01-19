def fibonacci(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    else:
        a = 0
        b = 1
        sum = 0
        for i in range(2, n+1):
            sum = a+b
            a = b
            b = sum
        return sum

def fibo0(n):
    if n == 0:
        return 1
    elif n == 1:
        return 0
    else:
        return fibonacci(n-1)
        
def fibo1(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    else:
        return fibonacci(n)

T = int(input())
for _ in range(T):
    n = int(input())        
    print(fibo0(n), fibo1(n))
