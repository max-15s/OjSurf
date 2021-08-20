# https://quera.ir/contest/assignments/31890/problems/106218


def code(input_str: str) -> str:
    return_str = [chr(ord(a)+1) for a in input_str]
    return_str = ''.join(return_str).replace('{', 'a')
    return return_str[-1]+return_str[:-1]


if __name__ == '__main__':
    str_len = int(input())
    k = int(input())
    input_str = input().strip()
    for i in range(k):
        input_str = code(input_str)
    print(input_str)

