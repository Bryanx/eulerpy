def find_smallest_multiple(a, b):
    e, x = [], 10
    for c in range(x, 240000000, 10):
        for d in range(a, b+1):
            if c % d == 0:
                if a == b:
                    return c
                else:
                    a += 1
            else:
                a = 3
                x += 10

print(find_smallest_multiple(2, 20))
