v, s = map(float,input().split())
v *= 1000/3600
t = 2*s / v
a = v / t
t = "{:.2f}".format(t)
a = "{:.2f}".format(a)
print(t,a)
