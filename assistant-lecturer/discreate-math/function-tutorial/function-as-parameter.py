def tambah(x):
    return x + 1
def kurang(x):
    return x - 1
def operation(val, func):
    return func(val)
print(operation(9,tambah))
print(operation(9,kurang))