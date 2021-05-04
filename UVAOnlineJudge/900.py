# 900 Brick Wall Patterns

if __name__ == '__main__':
    while True:
        length = int(input())
        if length == 0:
            break
        a = 1
        b = 1
        for _ in range(length):
            a, b = b, a+b
        print(a)
