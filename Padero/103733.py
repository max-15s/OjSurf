# https://quera.ir/contest/assignments/31569/problems/103733

def check(s, e, dp):
    if dp[s][e] == True:
        return True
    elif dp[s][e] == False:
        return False
    else:


if __name__ == '__main__':
    n, q = [int(i) for i in input().split()]
    dp = [[None]*(n+2)]*(n+2)
    tiles = ['0'] + [i for i in input().split()]
    for c in range(q):
        s, e = [int(i) for i in input().split()]
        if s > e:
            s, e = e, s
        if dp[s][e] == True:
            print('YES')
        elif dp[s][e] == False:
            print()
        while index < e:
            if dp[index+1] == True:
                print('YES')
                break
            elif dp[index+1] == False:
                print('NO')
                break
            else:
                if tiles[index] != tiles[index+1]:
                    dp[index] = True
                    index += 1
                    if index == e:
                        print('YES')
                else:
                    dp[index] = False
                    print('NO')
                    break





