def biggest_collatz(x):
    longest_seq, test = [], []
    for i in range(1, x+1):
        test.append(i)
        while i > 1:
            if i % 2 == 0:
                i //= 2
            else:
                i = i*3+1
            test.append(i)
        if len(test) > len(longest_seq):
            longest_seq = test
        test = []
    return longest_seq

print(biggest_collatz(1000))
