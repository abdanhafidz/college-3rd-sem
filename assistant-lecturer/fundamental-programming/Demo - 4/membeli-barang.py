N,M = map(int,input().split())
barang = list(map(int, input().split()))
uang = list(map(int, input().split()))
min_barang = min(barang)
max_barang = max(barang)
min_uang = min(uang)
max_uang = max(uang)
# Kasus Pertama Barang (+), Uang (+)
# Barang (+) -> min & max > 0 
if(min_barang > 0 and max_barang > 0 and min_uang > 0 and max_uang > 0 ):
    # Beli semua barang, bayar pake uang paling dikit
    hutang = min_uang - sum(barang)
# Kasus Pertama Barang (-), Uang (-)
elif(min_barang < 0 and max_barang < 0 and min_uang < 0 and max_uang < 0 ):
    # Beli barang paling mahal 1 biji, bayar pake utang (semua)
    # -1 -2 -3 -4
    # -3 -6 -6 -9
    hutang = sum(uang) - max(barang)
elif(min_barang < 0 and max_barang < 0 and min_uang > 0 and max_uang > 0 ):
    # Beli barang paling mahal 1 biji, bayar pake utang (semua)
    # -1 -2 -3 -4
    # -3 -6 -6 -9
    hutang = 0
else:
    belanja = 0
    bayar = 0
    for ambil_barang in barang:
        if(ambil_barang > 0):
            belanja += ambil_barang
    for ambil_uang in uang:
        if(ambil_uang < 0):
            bayar += ambil_uang
    hutang = bayar - belanja

print(hutang)
    