# https://quera.ir/problemset/contest/1359
# only second sentence should be checked against the first one


def traverse(first, second):
    found = False
    for step in [1, -1]:
        if found:
            return found
        if step == 1:
            final_value = len(second)
            index = 0
        else:
            final_value = -1
            index = len(second) - 1

        for lch in first:
            if lch == second[index]:
                index += step
                if index == final_value:
                    found = True
                    break
    return found


if __name__ == '__main__':
    n = int(input())
    for i in range(n):
        first = input()
        second = input()
        print('YES' if traverse(first, second) else 'NO')



