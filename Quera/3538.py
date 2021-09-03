# https://quera.ir/problemset/contest/3538

if __name__ == '__main__':
    week = {
        'shanbe': True,
        '1shanbe': True,
        '2shanbe': True,
        '3shanbe': True,
        '4shanbe': True,
        '5shanbe': True,
        'jome': True
    }

    for i in range(3):
        _ = input()
        days = [i.strip() for i in input().split()]
        for day in days:
            week[day] = False

    available_days = 0
    for day in week.values():
        if day:
            available_days += 1

    print(available_days)