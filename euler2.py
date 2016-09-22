def even_fibonacci_sum(x):
    f = [1, 2]
    e = []
    
    # keep generating fibonacci number untill x is reached:
    while f[len(f) - 2] + f[len(f) - 1] < x:
        f.append(f[len(f) - 2] + f[len(f) - 1])
        
    # remove all uneven fibonacci numbers:
    for i in f:
        if i % 2 == 0:
            e.append(i)
            
    # return the sum of all even numbers:
    return sum(e)


print(even_fibonacci_sum(4000000))
