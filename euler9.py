def find_pytho_product(x):
    for c in range(1, x):
        for b in range(c):
            for a in range(b):
                if a**2+b**2 == c**2 and a+b+c == x:
                    print(a,"+", b,"+", c,"is the only Pythagorean Triplet with outcome:", x)
                    print("The product of this triplet is:", a*b*c)

find_pytho_product(1000)
