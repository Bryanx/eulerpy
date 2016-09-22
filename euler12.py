from math import sqrt

def divisor(x):
    return [i for i in range(1, x+1, 1) if x % i == 0]


def traingularnumber_divisors(d):
    x = d*3**2
    while x != -1:
        if sqrt(8*x+1) % 1 == 0:
            if len(divisor(x)) > d:
                print(x)
                break
        x += 1

print(traingularnumber_divisors(500))
