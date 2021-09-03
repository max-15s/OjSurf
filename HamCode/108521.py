# https://quera.ir/contest/assignments/32393/problems/108521


def simple_validate(sequence: list, already_split: bool, first_half: int, second_half: int=None) -> bool:
    for g in range(1, len(sequence)):
        if sequence[g - 1] >= sequence[g] or sequence[g] > first_half:
            if sequence[g] > second_half:
                return False
            if already_split:
                return False
            else:
                f1 = simple_validate(sequence[:g], True, first_half, first_half)
                f2 = simple_validate(sequence[g:], True, second_half, second_half)
                return f1 and f2
    return True


if __name__ == '__main__':
    n, a, b = [int(i) for i in input().split()]
    a_i = [int(i) for i in input().split()]
    # a_i.sort()
    first_half = 45 + a
    second_half = 90 + b

    if simple_validate(a_i, False, first_half, second_half):
        print('YES')
    else:
        print('NO')