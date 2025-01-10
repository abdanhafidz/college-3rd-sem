## Pembahasan Soal DEMO 1 [Python] By Abdan Hafidz

## Soal 1 : Taxi Fare Calculator

**Deskripsi Soal**

Anda ingin naik taksi yang akan menjemput pada lokasi anda saat ini yaitu titik sesuai odometer yaitu `odometer_beginning_reading` miles , tujuan perjalanan anda adalah menuju `odometer_ending_reading`miles . Taxi tersebut mempunyai argo $1.50 per-mile nya. Tentukan berapa total biaya yang harus dibayarkan sesuai dengan argo yang diberikan.

**Penyelesaian**

Kita tahu bahwa total miles perjalanan adalah jarak antar lokasi penjemputan menuju lokasi tujuan. Untuk menentukan berapa besar ongkos yang akan dibayarkan kita tinggal membuat perkalian selisih jarak dengan besar argo.

`distance = abs(odometer_beginning_reading - odometer_ending_reading)`

`fare = distance*1.50`

```python
odometer_beginning_reading = float(input("Enter beginning odometer reading =>"))
odometer_ending_reading = float(input("Enter ending odometer reading =>"))
distance = float(abs(odometer_beginning_reading - odometer_ending_reading))
fare = float(distance * 1.50)
print("You travelled a distance of","{:.2f}".format(distance), "miles. At $1.50 per mile, your fare is","{:.2f}".format(fare))
```

*Nilai Bonus Jika :*

* Concern pembulatan agar dua angka di belakang koma, atau
* Pake abs

## Soal 2 : HydroElectric Dam

**Deskripsi Soal**

Anda ingin mendesign *Hydroelectric Dam* dari data yang diberikan yaitu ketinggian dam serta kecepatan arus. Diberikan konstanta :

1 meter cubic = 1000 kg

**Penyelesaian**

Kita tahu bahwa total miles perjalanan adalah jarak antar lokasi penjemputan menuju lokasi tujuan. Untuk menentukan berapa besar ongkos yang akan dibayarkan kita tinggal membuat perkalian selisih jarak dengan besar argo.

`distance = abs(odometer_beginning_reading - odometer_ending_reading)`

`fare = distance*1.50`

```python
odometer_beginning_reading = float(input("Enter beginning odometer reading =>"))
odometer_ending_reading = float(input("Enter ending odometer reading =>"))
distance = float(abs(odometer_beginning_reading - odometer_ending_reading))
fare = float(distance * 1.50)
print(f"You travelled a distance of {distance} miles. At $1.50 per mile, your fare is {fare}")
```

*Nilai Bonus Jika :*

* Concern pembulatan agar dua angka di belakang koma, atau
* Pake abs

## Soal 3 : Freezer Temperature

**Deskripsi Soal**

Diberikan  format waktu *{hours:mins}* anda akan menyatakannya dalam bentuk bilangan rasional *t* jam yaitu waktu yang sudah dilalui sejak daya freezer dimatikan, sebagai contoh "2 hours 30 minutes" dapat diubah ke *t = 2.5*. Anda akan menghitung estimasi bilangan rasional *T* sebagai temperatur dari freezer menggunakan persamaan :

![](https://latex.codecogs.com/svg.image?T=\frac{4t^2}{t+2}-20)

**Penyelesaian**

Pertama - tama kita akan mengubah format menit ke format jam lalu menambahkannya ke nilai jam yang sudah diperoleh dengan memanfaatkan bahwa 1 menit = 1/60 jam. Ini artinya :*

`t = hours + mins / 60`

Kemudian substitusi ke rumus

```python
hours, mins = map(int, input().split())
t = float(hours + mins/60)
T = float(((4 * t**2) / (t + 2)) - 20)
print("{:.2f}".format(T))
```

*Nilai Bonus Jika :*

* Input pakai map / split
* concern dua angka di belakang koma

## Soal 4 : Money Changer

**Deskripsi Soal**

Diberikan besaran nilai uang dalam dollar. Anda diminta untuk melakukan konversi ke nilai dalam mata uang pondsterling. Gunakan konstanta

1 USD = 0.65 GBP

**Penyelesaian**

Cukup mudah, hitung dan tampilkan

`dollar*65%`

```python
dollar = float(input())
print("{:.2f}".format(float(dollar*65%)))
```

*Nilai Bonus Jika :*

* Concern tipe data dolar dan ponds
* Dua angka di belakang koma

## Soal 5 : Hospitals

**Deskripsi Soal**

Diberikan Volume infused di mana proses satu kali penginfusan berdasarkan takaran yang diberikan memakan waktu selama waktu tertentu. Kita akan menentukan dalam satu jam berapa total ml infus yang dilakukan.

**Penyelesaian**

Misalkan waktu dalam satu kali penginfusan diinisiasi sebagai *t* dan dalam *t* menit takaran infusnya adalah *x* ml. ini artinya dalam satu jam akan ada *60 / t* kali penginfusan. Dan total ml infus yang dihabiskan adalah 60/t * x.

```python
x = float(input("Volume to be infused => "))
t = float(input("Minutes over which to infuse => "))
print("{:.2f}".format(x*60/t))
```

*Nilai Bonus Jika :*

* Concern tipe data float
* Pakai output format

## Soal 6 : Score Prediction

**Deskripsi Soal**

Kita diberi informasi berupa nilai yang diinginkan dalam kuliah berupa predikat berbentuk karakter , kemudian nilai minimum untuk mencapai itu. Diketahui kita memperoleh nilai rata - rata sementara dari perkuliahan dan akan mendapatkan nilai final setelah pembobotan yang diberikan. Kita akan menentukan berapa nilai final minimum yang diperlukan agar ketika dilakukan pembobotan untuk nilai akhir perkuliahan bisa mencapai nilai minimum untuk nilai yang diinginkan.

**Penyelesaian**

kita tahu bahwa bisa memperoleh nilai akhir dengan metode sebagai berikut umunya :

`nilai_akhir_kuliah = bobot_nilai_sementara * nilai_sementara + bobot_nilai_final * nilai_final`

di mana dengan mengetahui nilai `bobot_nilai_final` , kita dapat menentukan `bobot_nilai_sementara = (100  - bobot_nilai_final)/100`

Selanjutnya untuk menentukan `nilai_final` kita dapati dengan langkah substitusi :

`nilai_akhir_kuliah = bobot_nilai_sementara * nilai_sementara + bobot_nilai_final * nilai_final`

`nilai_akhir_kuliah = (100  - bobot_nilai_final)/100 * nilai_sementara + bobot_nilai_final/100 * nilai_final`

`nilai_akhir_kuliah = (100  - bobot_nilai_final)/100 * nilai_sementara + bobot_nilai_final/100 * nilai_final`

`nilai_akhir_kuliah = (1 - bobot_nilai_final/100) * nilai_sementara + bobot_nilai_final/100 * nilai_final`

`nilai_akhir_kuliah = nilai_sementara - nilai_sementara * bobot_nilai_final/100 + bobot_nilai_final/100 * nilai_final`

`nilai_akhir_kuliah = nilai_sementara - bobot_nilai_final/100 * (nilai_sementara + nilai_final)`

`bobot_nilai_final/100 * (nilai_sementara + nilai_final) = nilai_sementara - nilai_akhir_kuliah`

`nilai_sementara + nilai_final = (nilai_sementara - nilai_akhir_kuliah) / (bobot_nilai_final/100)`

`nilai_final = ((nilai_sementara - nilai_akhir_kuliah) / (bobot_nilai_final / 100)) - nilai_sementara`

di mana `nilai_akhir_kuliah = nilai_minimum` untuk mencapai predikat yang diinginkan

```python
grade = input("Enter desired grade >")
min_grade = float(input("Enter minimum average required >"))
current_average = float(input("Enter current average in course >"))
weight_final = float(input("Enter how much the final counts as a percentage of the course grade >"))
weight_final /= 100
final_grade = float(abs(((current_average - min_grade ) / weight_final) - current_average))
final_grade = "{:.2f}".format(final_grade)
print(f"You need a score of {final_grade} on the final to get {grade}")

```

*Nilai Bonus Jika :*

* Concern tipe data semuanya float (karena bobot bisa saja desimal)
* Pakai output format

## Soal 7 : BTUs Heat

**Deskripsi Soal**

Diberikan informasi berupa jumlah galon dari minyak yang terbakar dan nilai efisiensi. Dengan menggunakan konstanta energi BTU = 5.800.000 (untuk 42 galon) tentukan nilai akhir energi BTU yang dihasilkan!

**Penyelesaian**

Dengan menggunakan perbandingan kita akan temukan, bahwa energi BTU yang dihasilkan berdasarkan jumlah galon yang dihasilkan adalah `jumlah_galon / 42 * 5800000` dengan adanya efisiensi maka kita kalikan dengan ini.
Ditemukan
`energy_BTUs = (jumlah_galon / 42 * 5800000) * efisiensi`

```python

jumlah_galon = int(input())
effisiensi = float(input())
energy_amount = ( float(jumlah_galon / 42) * 5800000) * effisiensi
print(energy_amount)
```

*Nilai Bonus Jika :*

* Concern tipe data jumlah galon harus integer (diskrit)
* Pakai output format

## Soal 8 : Metro City

**Deskripsi Soal**

Diberikan informasi perancangan perubahan model Toilet, yang mula - mula memiliki kapasitas 2 liter per flush, kita akan mengganti dengan model baru yaitu 15 liter per flush, sebuah toilet mengalami flush sebanyak 14x per hari. Asumsi Penggunaan 1 toilet untuk maksimal 3 orang. Biaya untuk instalasi satu toilet adalah $150. Diberikan jumlah populasi, tentukan estimasi magnitude (liters/day) dan biaya yang dihemat dengan perubahan rancangan tersebut.

**Penyelesaian**

```python
old_litres_per_flush = 15
new_litres_per_flush = 2
cost_of_new_toilets = 150
toilets_per_person = 3
daily_number_of_flushes = 14
size_of_community = int(input())
cost_of_water_saved = size_of_community * cost_of_new_toilets;
toilets_are_used = (size_of_community / toilets_per_person)
if(size_of_community % 3 != 0):
    toilets_are_used += 1
old_water_flushed_per_day = (( toilets_are_used * daily_number_of_flushes) * old_litres_per_flush);
new_water_flushed_per_day = ((toilets_are_used * daily_number_of_flushes) * new_litres_per_flush);
litres_of_water_saved_per_day = old_water_flushed_per_day - new_water_flushed_per_day;
```

*Nilai Bonus Jika :*

* Concern tipe data jumlah galon harus integer (diskrit)
* Pakai output format

## Soal 9 : Yard

**Deskripsi Soal**

Diberikan informasi terkait halaman yang mempunyai panjang sebesar `length` dan lebar sebesar `width`. Jika kita ingin memotong rumput di halaman tersebut dengan kecepatan 2 feet^2/s. Berapa lama waktu yangd dibutuhkan untuk memotong habis rumput?

**Penyelesaian**
Kita tahu bahwa lama memotong rumputnya adalah `luas_lapangan / kecepatan` di mana `luas_lapangan = width * length`.

```python
width = float(input())
length = float(input())
area = width * length
time_measured = "{:.2f}".format(float(area / 2))
print(time_measured)
```

*Nilai Bonus Jika :*

* Pakai format

## Soal 10 : Perp. Bisector

**Deskripsi Soal**

Diberikan dua buah titik dengan koordinat (x1,y1) dan (x2,y2). Anda diminta untuk menentukan garis yang membagi tegak lurus pada segmen dua titik tersebut.

**Penyelesaian**
Karena tegak lurus itu artinya garis akan kita tarik dari titik tengah segmen yaitu `((x1 + x2)/2,(y1 + y2)/2)` kemudian kita akan menentukan kemiringan (m1) menggunakan rumus `(y2 - y1) / (x2 - x1)`. jika ada dua segmen garis yang saling tegak lurus mempunyai kemiringan berturut turut adalah m1 dan m2 maka kita dapat menentukan bahwa m1*m2 = -1.

Ini membuat m2 = -1/m1. Untuk kasus ini, dalam persamaan garis tegak lurus `y = m2*x + c` , menentukan `c` kita bisa menggunakan rumus `c = (y1 + y2)/2 - (m2 * (x1 + x2))`.

Anda harus mempertimbangkan kasus untuk m1 = 0 atau m1 = undefined karena akan menghasilkan pembagian dengan 0 dan ini akan membuat error. m1 = 0 adalah kasus saat y2 = y1 ,dan m1 = undefined saat x2 = x1.

```python
x1,y1 = map(float,input("Masukkan koordinat pertama x1 y1 dipisahkan oleh spasi => ").split())
x2,y2 = map(float,input("Masukkan koordinat kedua x2 y2 dipisahkan oleh spasi => ").split())
if(x1 == x2 or y1 == y2):
    print("Invalid Input")
else: 
    m1 = (y2 - y1) / (x2 - x1)
    m2 = float(-1/m1)
    c = float((y1 + y2)/2 - (m2 * (x1 + x2)/2))
    m2 = "{:.2f}".format(m2)
    c = "{:.2f}".format(c)
    print(f"Perp Bisector y = {m2}x + {c}")
```

*Nilai Bonus Jika :*

* Concern kasus di mana kemiringan = 0 atau undefined-> Pembagian dengan 0 (-1/0)
* Input map, inline input
* Concern tipe data float
* Pakai format

## Soal 11 : Pythagorean

**Deskripsi Soal**

Diberikan bilangan bulaty positif n dan m untuk m > n. Tentukan sisi segitiga siku - siku berdasarkan theorema pythagoras :
![](https://latex.codecogs.com/svg.image?side1=m^2-n^2,\;side2=2mn,\;hypotenuse=m^2+n^2)

**Penyelesaian**
Substitusi ke formula seperti biasa, namun hati - hati untuk kasus m <= n. Buatlah validatornya!

```python
m,n = map(int,input().split())
if(m > n):
    side1 = m**2 - n**2
    side2 = 2 * m * n
    hyp = m**2 + n**2
    print(side1, side2, hyp)
else:
    print("Invalid m and n value")
```

*Nilai Bonus Jika :*

* Membuat validator m > n

## Soal 12 : Jet Acceleration

**Deskripsi Soal**
Diberikan informasi berupa kecepatan dari sebuah jet dalam satuan km / jam dan panjang jaraknya dalam meter. Anda diminta untuk menentukan besar percepatannya dalam (m/s^2) menggunakan teorema fisika.

![](https://latex.codecogs.com/svg.image?v=at)

![](https://latex.codecogs.com/svg.image?s=\frac{1}{2}at^2)

**Penyelesaian**
Substitusi ke formula seperti biasa, namun hati - hati untuk kasus m <= n. Buatlah validatornya!

berdasarkan rumus kita dapat memperoleh

![](https://latex.codecogs.com/svg.image?s=\frac{1}{2}vt)

itu artinya untuk menentukan waktunya dengan menggunakan rumus

![](https://latex.codecogs.com/svg.image?t=\frac{2s}{v})

Rubah satuan waktu menjadi m / s = itu artinya kita tinggal mengkalikan kecepatan dengan 1000/3600.

Lalu berikutnya untuk menentukan besar percepatan gunakan rumus

![](https://latex.codecogs.com/svg.image?a=\frac{v}{t})

```python
m,n = map(int,input().split())
if(m > n):
    side1 = m**2 - n**2
    side2 = 2 * m * n
    hyp = m**2 + n**2
    print(side1, side2, hyp)
else:
    print("Invalid m and n value")
```

*Nilai Bonus Jika :*

* Concern tipe data float
* Menggunakan output format
* Menggunakan map
