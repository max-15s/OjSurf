# 12015 Google is Feeling Lucky

if __name__ == '__main__':
    T = int(input())
    for case in range(1, T+1):
        cache = dict()
        for i in range(10):
            url, value = input().split()
            value = int(value)
            if value in cache:
                cache[value].append(url)
            else:
                cache[value] = [url]
        for v in range(100, 0, -1):
            if v in cache:
                print(f'Case #{case}:')
                for url in cache[v]:
                    print(url.strip())
                break
