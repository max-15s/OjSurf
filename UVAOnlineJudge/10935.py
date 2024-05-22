from queue import SimpleQueue


if __name__ == '__main__':
    while True:
        n = int(input())
        if n == 0:
            break
        elif n == 1:
            print("Discarded cards:")
            print("Remaining card:", 1)
            continue

        outs = list()
        current = SimpleQueue()
        for i in range(1, n+1):
            current.put(i)

        cnt = 0
        while True:
            if current.qsize() == 1:
                print("Discarded cards:", ", ".join([str(i) for i in outs]))
                print("Remaining card:", current.get())
                break

            tmp = current.get()
            if cnt % 2 == 0:
                outs.append(tmp)
            else:
                current.put(tmp)
            cnt += 1
                
