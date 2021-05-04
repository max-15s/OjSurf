# 624 CD
# https://shareablecode.com/snippets/python-solution-for-uva-online-judge-624-cd-XPtu-iDnj
def print_k(k):
    for i in k:
        print(' '.join([str(_) for _ in i]))


if __name__ == '__main__':
    # max(song count) == 20
    while True:
        try:
            row = [int(i) for i in input().split()]
            W = row[0]
            n = row[1]
            weights = row[2:]
            K = list()
            for i in range(n+1):
                K.append(
                    [0 for _ in range(W+1)]
                )
                for w in range(W+1):
                    if i == 0 or w == 0:
                        K[i][w] = 0
                    elif weights[i-1] <= w:
                        # value is 1 each song has equal value
                        K[i][w] = max(weights[i-1] + K[i-1][w-weights[i-1]], K[i-1][w])

                    else:
                        K[i][w] = K[i-1][w]
                if K[i][w] == W:
                    break
                # print('\n\n', ' '.join([str(_) for _ in weights]))
                # print_k(path)
                # print_k(K)

            res = K[-1][W]
            # print(res)

            w = W
            included_items = list()
            for i in range(len(K), 0, -1):
                if res <= 0:
                    break
                # either the result comes from the
                # top (K[i-1][w]) or from (val[i-1]
                # + K[i-1] [w-wt[i-1]]) as in Knapsack
                # table. If it comes from the latter
                # one/ it means the item is included.
                if res == K[i - 1][w]:
                    continue
                else:

                    # This item is included.
                    included_items.append(str(weights[i - 1]))

                    # Since this weight is included
                    # its value is deducted
                    res = res - weights[i - 1]
                    w = w - weights[i - 1]

            print(' '.join(reversed(included_items)), f'sum:{sum(map(int, included_items))}')

        except EOFError:
            break
        except Exception:
            break



