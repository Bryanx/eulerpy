from math import sqrt, ceil; from itertools import count, islice

def find_prime(x):
    for i in range(1, x*11, 2):
        if all(i % c for c in islice(count(2), int(sqrt(i)))):
            x -= 1
            if x == 0:
                return i

print(find_prime(10001))
