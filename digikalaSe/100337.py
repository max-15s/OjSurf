# https://quera.ir/contest/assignments/30293/problems/100337
import copy
res = list()


def maker(vessel, n, k):
    global res
    if len(vessel) == n:
        res.append(''.join(str(i) for i in vessel))
        return
    if 0 <= vessel[-1] - k <= 9:
        maker(copy.deepcopy(vessel)+[vessel[-1] - k], n, k)
    if 0 <= vessel[-1] + k <= 9:
        maker(copy.deepcopy(vessel)+[vessel[-1] + k], n, k)


if __name__ == '__main__':
    n, k = [int(i) for i in input().strip().split()]
    for i in range(1, 10):
        maker([i], n, k)
    print(','.join(res))

