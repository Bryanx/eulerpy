def find_biggest_palindrome(x):
    e = []
    for a in range(x):
        for b in range(x):
            if str(a*b)[::-1] == str(a*b):
                e.append(a*b)
    return(max(e))

print(find_biggest_palindrome(1000))
