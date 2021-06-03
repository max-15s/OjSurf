# https://quera.ir/problemset/contest/3429

if __name__ == '__main__':
    n = int(input())
    if n < 0:
        print("Ice")
    elif n > 100:
        print("Steam")
    else:
        print("Water")
