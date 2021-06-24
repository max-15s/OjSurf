# https://quera.ir/problemset/contest/10230
# Sum of triangle degrees should be exactly 180 and bigger than zero

if __name__ == '__main__':
    degrees = [int(d) for d in input().split()]
    if sum(degrees) == 180 and 0 not in degrees:
        print('Yes')
    else:
        print('No')
