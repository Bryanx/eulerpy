from math import sqrt; from itertools import count, islice

def find_prime(x):
    lst = [2]
    for i in range(3, x, 2):
        if all(i % c for c in islice(count(2), int(sqrt(i)))):
            lst.append(i)
    return sum(lst)

print(find_prime(2000000))
