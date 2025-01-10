class ptr:
    def __init__(self, *args):
        for arg in args.item():
            self.arg = arg

def add(var):
    var += 1


ptr1 = ptr(x = 1, y = 2)
add(ptr.x)
print(ptr.x)


    