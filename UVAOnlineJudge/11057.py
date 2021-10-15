# 11057 Exact Sum
# 2 <= N <= 10_000 number of available books
# cost of a book < 1000001
# M an integer which is amount of money
# there is a blank line after each case and an EOF at the end
# find i and j where i < j and they cost exactly M
while True:
    try:
        N = int(input())
        tmp = [int(i) for i in input().split()]
        tmp.sort()

        values = dict()
        for i in tmp:
            if i in values:
                values[i] += 1
            else:
                values[i] = 1

        M = int(input())

        results = list()
        for first in tmp:
            second = M - first
            if second in values:
                if first != second:
                    results.append(
                        (first, second)
                    )
                else:
                    if values[second] > 1:
                        results.append(
                            (first, second)
                        )

        answer = results[0]
        min_diff = abs(results[0][1] - results[0][0])
        for item in results:
            if min_diff > abs(item[1] - item[0]):
                min_diff = abs(item[1] - item[0])
                answer = (min(item), max(item))
        print(f"Peter should buy books whose prices are {answer[0]} and {answer[1]}.\n")
        _ = input()  # throw away

    except EOFError:
        break
    except Exception:
        break