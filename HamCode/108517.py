# https://quera.ir/contest/assignments/32393/problems/108517
if __name__ == '__main__':
    name = input().strip()
    vowels = 'aeiou'
    cnt = 0
    for ch in name:
        if ch in vowels:
            cnt += 1
    print(2 ** cnt)
