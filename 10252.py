# 10252 - Common Permutation

if __name__ == '__main__':
    try:
        while True:
            alphabet1 = [0] * 26
            alphabet2 = [0] * 26
            line1 = input()
            for ch in line1:
                alphabet1[ord(ch) - 97] += 1

            line2 = input()
            for ch in line2:
                alphabet2[ord(ch) - 97] += 1

            res = list()
            for i in range(len(alphabet1)):
                if alphabet1[i] and alphabet2[i]:
                    res.extend(
                        [chr(i + 97)]*min(alphabet1[i], alphabet2[i])
                    )

            print(''.join(res))
    except:
        pass