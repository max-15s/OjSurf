from datetime import datetime


def convert_time_query(date_time_str):
    # 2020-05-20T09:00
    return datetime.strptime(date_time_str, '%Y-%m-%dT%H:%M')


def in_between(q_st_h, q_st_m, st_h, st_m, et_h, et_m):
    if st_h < q_st_h < et_h:
        return True
    if q_st_h == st_h:
        if st_m <= q_st_m:
            return True
    if q_st_h == et_h:
        if et_m >= q_st_m:
            return True
    return False


if __name__ == "__main__":
    exceptions = {
        'Station': list(),
        'Store': list(),
        'Tenant': list()
    }
    defaults = {
        0: list(),
        1: list(),
        2: list(),
        3: list(),
        4: list(),
        5: list(),
        6: list()
    }
    days_mapping = ['Monday','Tuesday','Wednesday','Thursday','Friday','Saturday','Sunday']
    n, m, q = [int(i) for i in input().strip().split()]
    for i in range(n):
        day, start_time, end_time = input().strip().split()
        day_number = days_mapping.index(day)
        st_h, st_m = [int(j) for j in start_time.split(':')]
        et_h, et_m = [int(j) for j in end_time.split(':')]
        defaults[day_number].append(
            {
                'st': [st_h, st_m],
                'et': [et_h, et_m]
            }
        )
    for i in range(m):
        pri, st_str, et_str, op_str = input().strip().split()
        exceptions[pri].append(
            {
                'st': convert_time_query(st_str),
                'et': convert_time_query(et_str),
                'op': op_str
            }
        )
    for i in range(q):
        query = convert_time_query(input().strip())
        flag = None
        for ex_store in exceptions.values():
            for ex in ex_store:
                if ex['st'] <= query <= ex['et']:
                    if ex['op'] == 'open':
                        flag = True
                    else:
                        flag = False
                    break
            if flag is not None:
                break
        if flag is None:
            for item in defaults[query.weekday()]:
                ftmp = in_between(
                    query.hour, query.minute,
                    item['st'][0], item['st'][1],
                    item['et'][0], item['et'][1],
                )
                if ftmp:
                    flag = True
                    break
        if flag:
            print('true')
        else:
            print('false')











