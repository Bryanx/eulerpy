import math

# find all uneven divisors of sqrt x:
def divisor(x):
    return [i for i in range(3, int(math.sqrt(x)+1), 2) if x % i == 0]

#find all uneven divisors of sqrt x that are prime:
def prime_factors(x):
    e = []
    for a in divisor(x):
        if divisor(a) == []:
            e.append(a)
    return e

print(prime_factors(600851475143))
