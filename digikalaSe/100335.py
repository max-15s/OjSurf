# https://quera.ir/contest/assignments/30293/problems/100335

if __name__ == '__main__':
    n = int(input())
    value_list = [int(i) for i in input().strip().split()]
    k = int(input())

    chance = 0
    for i in range(k):
        mm = max(value_list)
        chance += mm
        for j in range(n):
            if value_list[j] == mm:
                value_list[j] -= 1
                break
    print(chance % (10**9 + 7))