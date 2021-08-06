# https://quera.ir/contest/assignments/31569/problems/103731
if __name__ == '__main__':
    numbers = [int(i) for i in input().split()]
    pecks = [1 if i >= 80 else 0 for i in numbers]
    if sum(pecks) >= 3:
        print('Mamma mia!')
    elif sum(pecks) >= 1:
        print('Mamma mia!!')
    else:
        print('Mamma mia!!!')

