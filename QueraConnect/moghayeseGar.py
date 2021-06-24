def compare(string1, string2):
    s1 = list(string1)
    s2 = list(string2)
    while len(s1) > 0 and len(s2) > 0:
        if s1[0] < s2[0]:
            s1.remove(s1[0])
        elif s1[0] > s2[0]:
            s2.remove(s2[0])
        else:
            s1.remove(s1[0])
            s2.remove(s2[0])
        s1.reverse()
        s2.reverse()
    if len(s1):
        s1.reverse()
        return ''.join(s1)
    elif len(s2):
        s2.reverse()
        return ''.join(s2)
    else:
        return 'Both strings are empty!'
