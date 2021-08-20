# https://quera.ir/problemset/contest/3409

if __name__ == '__main__':
    n = int(input())
    row = list(range(1, n+1))
    for i in range(1, n+1):
        print(' '.join([str(j * i) for j in row]))