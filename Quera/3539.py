# https://quera.ir/problemset/contest/3539
from functools import lru_cache

@lru_cache(maxsize=1000)
def sum_up(big_num: str):
    half = len(big_num)//2
    if half == 0:
        return int(big_num)
    left = sum_up(big_num[:half])
    right = sum_up(big_num[half:])
    total = left + right
    subtotal = 0
    for i in range(len(str(total))):
        subtotal += total % 10
        total = total // 10
    return subtotal


if __name__ == '__main__':
    n = input()
    print(sum_up(n))