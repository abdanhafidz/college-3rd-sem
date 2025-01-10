
X = 9

def tambah(X):
    X += 1
def kurang():
    global X
    X -= 1
tambah(X)
kurang()
print(X)
