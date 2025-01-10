def f(n):
    if(n == 1 or n == 2):return 1
    return f(n - 1) + f(n - 2)
print(f(6))