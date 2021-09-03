# https://quera.ir/contest/assignments/32393/problems/108519

bank = dict()


def REGISTER(line):
    username = line.split()[1]
    if username in bank:
        print('Duplicate User!')
    else:
        bank['username'] = {
            'balance': 100
        }
        print('Registered Successfully')


def DEPOSIT(line):
    username, amount = line.split(1, 2)
    if username not in bank:
        print('No Such User Found!')
    else:
        bank[username]['balance'] += int(amount)


def min_change(denom: list, available_counts: list, change_amount: int):
    n = len(denom)
    count = [0] * (change_amount + 1)
    selected = [0] * (change_amount + 1);

    count[0] = 1
    for i in range(change_amount):
        if count[i] > 0:
            for j in range(n):
                p = i + denom[j]
                if p <= change_amount:
                    if count[p] == 0 or count[p] > count[i] + 1:
                        count[p] = count[i] + 1;
                        selected[p] = j

    # No solutions:
    if count[change_amount] == 0:
        return None;

    # Build answer.
    result = [0] * (count[change_amount] - 1)
    k = change_amount
    while k > 0:
        result[count[k] - 2] = denom[selected[k]]
        k = k - denom[selected[k]]

    return result


print(min_change([100, 50, 10, 5, 1], [3, 3, 3, 3, 3], 9))
