# https://quera.ir/problemset/contest/8838

if __name__ == '__main__':
    number, filename = input().strip().split()
    sequence = ['copy of'] * int(number)
    sequence.append(filename)
    print(' '.join(sequence))
