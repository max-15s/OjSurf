# 489 Hangman Judge

# one letter at a time
# if the letter is acceptable, all of them will be “turned over.”
# every wrong guess, gets an strike. After 7 strikes the game is fail
# Each unique wrong guess only counts against the contestant once.

from string import ascii_lowercase

if __name__ == '__main__':
    while True:
        round_number = int(input())
        if round_number == -1:
            break
        answer = input().strip().lower()
        guess = input().strip().lower()
        game_dict = dict()
        for ch in ascii_lowercase:
            game_dict[ch] = False

        strike_count = 0
        correct_count = 0
        answer_len = len(answer)
        for ch in guess:
            if ch in answer and game_dict[ch]:
                continue
            if ch in answer:
                game_dict[ch] = True
                correct_count += answer.count(ch)
                continue
                if correct_count == answer_len:
                    break
            if game_dict[ch]:
                continue
            else:
                game_dict[ch] = True
                strike_count += 1
                if strike_count == 7:
                    break

        print('Round', round_number)
        if correct_count == answer_len:
            print('You win.')
        elif strike_count == 7:
            print('You lose.')
        else:
            print('You chickened out.')





