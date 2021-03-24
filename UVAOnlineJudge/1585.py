# 1585 - Score

if __name__ == '__main__':
    number_of_cases = int(input())
    for i in range(number_of_cases):
        line = input()
        ct = 1
        score = 0
        for ch in line:
            if ch == 'O':
                score += ct
                ct += 1
            else:
                ct = 1
        print(score)
