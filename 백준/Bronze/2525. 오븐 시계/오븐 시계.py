time, minute = map(int, input().split())
m = int(input())
minute += m
time += minute//60
minute %= 60
print(str(time%24)+" "+str(minute))