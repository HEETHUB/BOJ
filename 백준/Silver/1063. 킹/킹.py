# R L T B 순
comA = [1, -1, 0, 0]
comN = [0, 0, 1, -1]
alpha = ['A','B','C','D','E','F','G','H']
num = ['1','2','3','4','5','6','7','8']

def moving(horse: str, com: str, alpha, num)-> str:
    horse = horse.copy()
    if com == 'R':
        if horse[0] != 'H':
            horse[0] = alpha[alpha.index(horse[0])+1]
    if com == 'L':
        if horse[0] != 'A':
            horse[0] = alpha[alpha.index(horse[0])-1]
    if com == 'T':
        if horse[1] != '8':
            horse[1] = num[num.index(horse[1])+1]
    if com == 'B':
        if horse[1] != '1':
            horse[1] = num[num.index(horse[1])-1]
    if com == 'RT':
        if horse[0] != 'H' and horse[1] != '8':
            horse[0] = alpha[alpha.index(horse[0])+1]
            horse[1] = num[num.index(horse[1])+1]
    if com == 'RB':
        if horse[0] != 'H' and horse[1] != '1':
            horse[0] = alpha[alpha.index(horse[0])+1]
            horse[1] = num[num.index(horse[1])-1]
    if com == 'LT':
        if horse[0] != 'A' and horse[1] != '8':
            horse[0] = alpha[alpha.index(horse[0])-1]
            horse[1] = num[num.index(horse[1])+1]
    if com == 'LB':
        if horse[0] != 'A' and horse[1] != '1':
            horse[0] = alpha[alpha.index(horse[0])-1]
            horse[1] = num[num.index(horse[1])-1]
    return horse

king, stone, N = input().split()
king, stone = list(king), list(stone)
N = int(N)

for i in range(N):
    move = input()
    if moving(king, move, alpha, num) == stone:
        if stone != moving(stone, move, alpha, num):
            stone = moving(stone, move, alpha, num)
            king = moving(king, move, alpha, num)
    else:
        king = moving(king, move, alpha, num)
    
print(''.join(king))
print(''.join(stone))
