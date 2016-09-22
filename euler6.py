def difference_sumsqr_sqrsum(x):
    sumsqr = []
    sqrsum = []
    for i in range(x+1):
        sumsqr.append(i**2)
        sqrsum.append(i)
    difference = sum(sqrsum)**2 - sum(sumsqr)
    return difference

print(difference_sumsqr_sqrsum(100))
