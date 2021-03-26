# 10130 - SuperSale
from functools import lru_cache


if __name__ == '__main__':
    T = int(input())
    for i in range(T):
        num_items = int(input())
        DP = [0]*31
        for j in range(num_items):
            v, w = [int(x) for x in input().split()]
            for k in range(30, w-1, -1):
                if DP[k] < DP[k-w]+v:
                    DP[k] = DP[k-w]+v
        num_people = int(input())
        total = 0
        for j in range(num_people):
            pw = int(input())
            total += DP[pw]
        print(total)
