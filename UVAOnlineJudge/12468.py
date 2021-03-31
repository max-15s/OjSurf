# 12468 Zapping

if __name__ == '__main__':
    while True:
        a, b = [int(num) for num in input().split()]
        if a < 0:
            break
        if a > b:
            a, b = b, a
        print(min(b-a, a+100-b))