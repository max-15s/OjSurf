# 11057 Exact Sum
# 2 <= N <= 10_000 number of available books
# cost of a book < 1000001
# M an integer which is amount of money
# there is a blank line after each case and an EOF at the end
while True:
    try:
        N = int(input())
        weights = [int(i) for i in input().split()]
        M = int(input())
        K = list()
        for i in range(N+1):
            K.append(
                [0 for _ in range(M+1)]
            )
            for w in range(M+1):
                if i == 0 or w == 0:
                    K[i][w] = 0
                elif weights[i-1] <= w:
                    K[i][w] = max(weights[i-1] + K[i-1][w-weights[i-1]], K[i-1][w])
                else:
                    K[i][w] = K[i-1][w]
        w = M
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