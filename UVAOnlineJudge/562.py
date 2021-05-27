# 562 Dividing coins

# We check if we can achieve each coin, from adding some other coins
# The logic is if we give a large coin to someone, we should be able to give it's equivalent to the other person with
#  smaller coins

if __name__ == '__main__':
    n = int(input())
    for i in range(n):
        m = int(input())
        coins = [int(c) for c in input().split()]
        total = sum(coins)
        fair_half = total // 2
        value = [False]*(fair_half+1)
        value[0] = True
        for c in coins:
            for v in range(fair_half, 0, -1):
                if c <= v:
                    if not value[v]:
                        value[v] = value[v - c]

        for v in range(len(value)-1, -1, -1):
            if value[v]:
                print(total - (2 * v))
                break
