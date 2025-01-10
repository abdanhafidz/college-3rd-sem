# Pass By Value
usiaUstu = 19

def ultah(usia:int):
    usia += 1
    return usia
usiaSetelah = ultah(usiaUstu)
ultah(usiaUstu)
print(usiaUstu)

# Pass By Refference
Ustu = {
    "nama":"Ustu Bina S",
    "usia": 19
}
print("Usia sebelum", Ustu["usia"])
def ultahByRef(orang:dict):
    orang["usia"] += 1

ultahByRef(Ustu)
print("Usia setelah ultah", Ustu["usia"])

daftar = [1,2]
def addElement(arr:list, x:int):
    arr.append(x)

addElement(daftar, 3)
print(daftar)

x = 20
y = {
    "value":20
}

def add(x:int, y:dict):
    x += 1
    y["value"] += 1

add(x,y)
print(x)
print(y)

a = 20

def a(a):
    a += 1
    return a
nilai = a(a)
print(nilai)