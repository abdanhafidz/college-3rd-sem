N,M = map(int,input().split())
barang = list(map(int, input().split()))
uang = list(map(int, input().split()))
min_barang = min(barang)
max_barang = max(barang)
min_uang = min(uang)
max_uang = max(uang)
all_barang_positif = (min_barang > 0 and max_barang > 0)
all_uang_positif = (min_uang > 0 and max_uang > 0)
all_barang_negatif = (min_barang < 0 and max_barang < 0)
all_uang_negatif = (min_uang < 0 and max_uang < 0)
if(all_barang_negatif and all_uang_positif):
    hutang = 0
elif(all_uang_positif): # All Uang Positif and All Barang not negative
    hutang = min_uang - sum(list(filter(lambda x: x > 0, barang)))
elif(all_barang_negatif): # All uang not positif and all barang negative
    hutang = sum(list(filter(lambda x: x < 0, uang))) - max(barang)
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
    