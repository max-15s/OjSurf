# https://quera.ir/problemset/contest/3405

if __name__ == '__main__':
    numbers = list()
    while True:
        n = int(input())
        if n == 0:
            break
        numbers.append(n)

    for n in range(len(numbers)-1, -1, -1):
        print(numbers[n])