import math

if __name__ == "__main__":
    q = int(input())
    for i in range(q):
        total = 0
        l, r = [int(i) for i in input().strip().split()]
        sq_l = math.floor(math.sqrt(l))
        sq_r = math.ceil(math.sqrt(r))
        for num in range(sq_l, sq_r+1):
            if l <= num * num <= r:
                total += 1
        print(total)
