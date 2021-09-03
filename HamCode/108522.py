# https://quera.ir/contest/assignments/32393/problems/108522


def condition_one(str1: str, str2: str) -> bool:
    if abs(len(str1) - len(str2)) != 1:
        return False
    if len(str2) > len(str1):
        str1, str2 = str2, str1
    index1 = 0
    index2 = 0
    found_diff = False
    for i in range(len(str2)):
        if str1[index1] != str2[index2]:
            if found_diff:
                return False
            else:
                found_diff = True
                index1 += 1
        else:
            index1 += 1
            index2 += 1
    return True


def condition_two(str1, str2):
    if abs(len(str1) - len(str2)) > 0:
        return False
    found_diff = False
    for i in range(len(str2)):
        if str1[i] != str2[i]:
            if found_diff:
                return False
            else:
                found_diff = True
    return True


def condition_three(str1: str, str2: str):
    return str1.lower() == str2.lower()


if __name__ == '__main__':
    n, k = [int(i) for i in input().split()]
    doubt_list = list()
    valid_list = list()

    for i in range(n):
        doubt_list.append(
            input().strip()
        )
    for i in range(k):
        valid_list.append(
            input().strip()
        )

    # valid_list.extend(doubt_list)
    for valid_word in valid_list:
        cnt = 0
        for doubt_word in doubt_list:
            if condition_one(valid_word, doubt_word):
                cnt += 1
                continue
            elif condition_two(valid_word, doubt_word):
                cnt += 1
                continue
            elif condition_three(valid_word, doubt_word):
                cnt += 1
                continue
        print(cnt)
