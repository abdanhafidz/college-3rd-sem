
jumlah_galon = int(input())
effisiensi = float(input())
energy_amount = "{:.2f}".format(( float(jumlah_galon / 42) * 5800000) * effisiensi)
print(energy_amount)
