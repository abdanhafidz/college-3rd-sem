# Bottom Up
f = [0,1,1,2]
for i in range(3,10):
    # f[i] = f[i - 1] + f[i - 2]
    print(f"f({i}) = f({i - 1}) + f({i - 2})")
    