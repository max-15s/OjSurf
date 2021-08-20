# https://quera.ir/contest/assignments/31890/problems/106219
from math import sqrt, ceil, floor
from itertools import count, islice


def is_prime(n):
    return n > 1 and all(n % i for i in islice(count(2), int(sqrt(n)-1)))

def find_symmetry(index, center):
    if index[0] < center[0]:
        re_i = ceil(index[0] + 2 * (center[0]-index[0]))
    else:
        re_i = ceil(index[0] - 2 * (index[0] - center[0]))

    if index[1] < center[1]:
        re_j = ceil(index[1] + 2 * (center[1]-index[1]))
    else:
        re_j = ceil(index[1] - 2 * (index[1] - center[1]))
    print(index, center)
    print(re_i, re_j)
    return [re_j-1, re_i-1]

if __name__ == '__main__':
    n, m, k = [int(a) for a in input().split()]
    center = [m / 1.99, n / 1.99]
    if n % 2:
        center[1] = floor(n/2)+1
    if m % 2:
        center[0] = floor(m/2)+1

    town_map = [[0]*m]*n
    for i in range(n):
        town_map[i] = [int(a) for a in input().split()]

    index = [0, 0]
    for i in range(k):
        if is_prime(town_map[index[0]][index[1]]):
            index = find_symmetry([index[0]+1, index[1]+1], center)
        elif town_map[index[0]][index[1]] % 4 == 0:
            index[1] += 1
        elif town_map[index[0]][index[1]] % 4 == 1:
            index[0] += 1
        elif town_map[index[0]][index[1]] % 4 == 2:
            index[0] -= 1
        elif town_map[index[0]][index[1]] % 4 == 3:
            index[1] -= 1

        if index[0] < 0:
            index[0] = n - 1
        if index[0] >= n:
            index[0] = 0
        if index[1] < 0:
            index[1] = m - 1
        if index[1] >= m:
            index[1] = 0
    print(index[0]+1, index[1]+1)
