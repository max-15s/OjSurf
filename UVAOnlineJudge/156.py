# 156 - Ananagrams

if __name__ == '__main__':
    dictionary = dict()
    while True:
        line = input()
        if line.strip() == '#':
            break
        words = line.split()
        for word in words:
            key = ''.join(sorted(word.lower()))
            if key in dictionary:
                dictionary[key].append(word)
            else:
                dictionary[key] = [word]
    result = list()
    for key in dictionary:
        if len(dictionary[key]) == 1:
            result.extend(dictionary[key])
    sorted_result = sorted(result)
    for word in sorted_result:
        print(word)
