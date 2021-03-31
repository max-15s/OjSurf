# 10684 The jackpot


def get_num():
    while True:
        for num in [int(num) for num in input().split()]:
            yield num


if __name__ == '__main__':
    len_of_seq = -1
    seq = list()
    for num in get_num():
        if len_of_seq == -1:
            len_of_seq = num
            if len_of_seq == 0:
                break
            continue

        if len(seq) < len_of_seq:
            seq.append(num)
            continue
        else:
            len_of_seq = num
        total = 0
        max_total = 0
        for i in seq:
            total += i
            if total < 0:
                total = 0
            if max_total < total:
                max_total = total
        seq.clear()
        if max_total > 0:
            print(f'The maximum winning streak is {max_total}.')
        else:
            print('Losing streak.')
        if len_of_seq == 0:
            break
