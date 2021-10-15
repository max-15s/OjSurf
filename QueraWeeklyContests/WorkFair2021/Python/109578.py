# https://quera.ir/contest/assignments/32558/problems/109578

def game(number):
    a, b = [int(ch) for ch in str(number)]
    return abs(a - b)

# print(game(17))
# print(game(66))
# print(game(81))

