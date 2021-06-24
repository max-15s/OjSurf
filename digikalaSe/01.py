
if __name__ == "__main__":
    n = input()
    last_time = None
    while n != last_time:
        last_time = n
        store = dict()
        for c in n:
            if c in store:
                store[c] += 1
            else:
                store[c] = 1
        sort_num = list(store)
        # sort_num.sort()
        re_num = list(store)
        for c in sort_num:
            if store[c] > 1:
                re_num.append(str(store[c]))
        re_num.sort()
        n = f'{"".join(re_num)}'
    print(n)
