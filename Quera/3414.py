# https://quera.ir/problemset/contest/3414

if __name__ == '__main__':
    x_1, y_1, x_2, y_2 = [int(i) for i in input().split()]
    if y_1 == y_2:
        print('Horizontal')
    elif x_1 == x_2:
        print('Vertical')
    else:
        print('Try again')
