def moveValue(move):
    print('value from {}'.format(move))
    if move == 'R':
        return 1
    if move == 'P':
        return 2
    if move == 'S':
        return 3

def loseFor(move):
    if move == 'A':
        return 'S'
    if move == 'B':
        return 'R'
    if move == 'C':
        return 'P'

def drawFor(move):
    if move == 'A':
        return 'R'
    if move == 'B':
        return 'P'
    if move == 'C':
        return 'S'

def winFor(move):
    if move== 'A':
        return 'P'
    if move == 'B':
        return 'S'
    if move == 'C':
        return 'R'


def outcomeValue(moves):
    print('outcome from {} {}'.format(moves[0],moves[1]))
    if moves[1] == 'X':
        return moveValue(loseFor(moves[0]))
    elif moves[1] == 'Y':
        return 3 + moveValue(drawFor(moves[0]))
    elif moves[1] == 'Z':
        return 6+ moveValue(winFor(moves[0]))

with open("input.txt") as f:
    moves = f.read().split('\n')
    del moves[len(moves)-1]
    print(moves)
    points = []
    for move in moves:
        print(move)
        parses = move.split(' ')
        points.append(outcomeValue(parses))
    total = 0
    for point in points:
        total = total + point
    print(total)
