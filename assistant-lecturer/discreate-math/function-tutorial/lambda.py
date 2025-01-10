def g(x, func):
    return func(x) + 3

hasil_f = lambda x : (x + 3)
# f(3) = 3 + 3 = 6
# g(3) = f(3) + 2 = 6 + 2 = 8
hasil_g = lambda x,func : (func(x) + 2)
# print(hasil_g(3,hasil_f))
print(hasil_g(3,hasil_f))