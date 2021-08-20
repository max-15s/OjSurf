# https://quera.ir/problemset/contest/10325

if __name__ == '__main__':
    r, c = [int(i) for i in input().split()]
    if c >= 11:
        d_c = 20 - c + 1
    else:
        d_c = c
    print("Left" if c >= 11 else "Right", 10 - r + 1, d_c)
