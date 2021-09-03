# https://quera.ir/problemset/contest/4065

if __name__ == '__main__':
    a, b, l = [int(i) for i in input().split()]
    number_of_full_cycle = (l // 2) * (a + b)
    if l % 2 == 0:
        print(number_of_full_cycle)
    else:
        print(number_of_full_cycle + a)
