# https://quera.ir/contest/assignments/31569/problems/103732
if __name__ == '__main__':
    n = int(input())

    for i in range(n-1, 0, -1):
        if n % i == 0:
            print(i)
            break
