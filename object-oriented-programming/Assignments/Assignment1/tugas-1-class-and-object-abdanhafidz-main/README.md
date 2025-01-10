[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/zLEBPE1z)
# oop-class-and-object

## Capaian Pembelajaran

1. Mahasiswa mampu mendeklarasikan kelas yang menerapkan prinsip encapsulation dan information hiding.
2. Mahasiswa mampu menginstansiasi kelas menjadi object dan mengoperasikan metode-metode di objek tersebut.

## Cara Pengerjaan menggunakan Eclipse IDE

1. Clone repositori project `oop-class-and-object` ke local direktori git Anda.
2. Buka Eclipse IDE > pilih menu File > Import > Maven > Existing Maven Projects.
3. Pada Root Directory, klik tombol Browse, pilih direktori `oop-class-and-object`, kemudian check `pom.xml`.
4. Tekan tombol finish untuk melakukan tombol impor.
5. Baca soal dengan seksama. Buat kelas solusi di package id.its.pbo.
6. Jalankan unit test dengan cara: klik kanan di project > Run As > JUnit Test / Maven Test.
7. Untuk menjalankan kelas yang memiliki method main. Klik kanan di kelas > Run As > Java Application.

## Soal-soal

### Invoice

Buatlah sebuah kelas bernama `Invoice` yang digunakan oleh sebuah toko untuk merepresentasikan sebuah faktur untuk barang yang dijual di toko tersebut. Sebuah `Invoice` memiliki empat informasi sebagai variabel instance yaitu: part number / nomor barang (tipe String), part description / deskripsi barang (tipe String), kuantitas barang yang dibeli (tipe int), dan harga per barang (double). Kelas `Invoice` harus memiliki sebuah konstruktor yang menginisialisasi keempat variabel instance tersebut. Sediakan metode setter dan getter public untuk masing-masing variabel instance yaitu `partNumber`, `partDescription`, `quantity`, dan `price`. Selain itu, sediakan sebuah metode bernama `getInvoiceAmount` yang menghitung jumlah faktur (yaitu, mengalikan kuantitas dengan harga per barang), kemudian mengembalikan jumlah tersebut sebagai nilai double. Jika kuantitasnya tidak positif, maka harus diatur menjadi 0. Jika harga per barang tidak positif, maka harus diatur menjadi 0,0. Buatlah sebuah kelas bernama `InvoiceProgram` yang didalamnya terdapat metode static `main`. Instansiasi 2 objek dari kelas `Invoice` menggunakan keyword `new`, set variabel instancenya, dan panggil metode `getInvoiceAmount`. 

### Employee

Buatlah sebuah kelas bernama `Employee` yang memiliki tiga variabel instance yaitu: nama depan (tipe String), nama belakang (tipe String), dan gaji bulanan (double). Sediakan sebuah konstruktor yang menginisialisasi ketiga variabel instance tersebut. Nama depan dan nama belakang tidak boleh diganti setelah konstruksi objek. Sediakan metode getter untuk  variabel instance `firstName` dan `lastName`. Sediakan metode getter dan setter untuk variabel instance `monthlySalary`. Jika gaji bulanan tidak positif, jangan set nilainya. Tulis sebuah aplikasi tes bernama `EmployeeProgram` yang menunjukkan kemampuan kelas `Employee`. Buat dua objek dari kelas `Employee` di dalam metode `main`. Tampilkan gaji tahunan dari masing-masing objek menggunakan metode `getYearlySalary`. Kemudian berikan masing-masing Employee kenaikan gaji sebesar 10% dengan memanggil metode `raiseSalary` milik kelas `Employee`. Metode `raiseSalary` memiliki parameter input persentase kenaikan bertipe `int` dan return type `void`. Tampilkan gaji tahunan yang terbarui dari masing-masing objek.

### Date

Buatlah sebuah kelas bernama `Date` yang memiliki tiga variabel instance yaitu: bulan (tipe int), hari (tipe int), dan tahun (tipe int). Sediakan sebuah konstruktor yang menginisialisasi ketiga variabel instance tersebut dan mengasumsikan bahwa nilai yang diberikan sudah benar. Sediakan metode set dan get untuk masing-masing variabel instance yaitu `month`, `day`, dan `year`. Pastikan nilai bulan diantara 1-12, nilai hari diantara 1-31, dan tahun tidak negatif. Pastikan nilai hari sesuai dengan ketentuan tiap bulannya. Jika tahun merupakan bukan non-kabisat, maka di bulan februari hari yang berlaku hanya 1-28. Jika bulan invalid, maka set default ke bulan 1. Jika hari invalid, maka set default ke hari 1. Jika tahun invalid, maka set default ke tahun 0. Sediakan sebuah metode `displayDate` yang mengembalikan string berisi bulan, hari, dan tahun yang dipisahkan oleh garis miring (/). Tulis sebuah aplikasi bernama `DateProgram` yang menunjukkan kemampuan kelas `Date`.


## Referensi

Soal diambil dari buku Java How to Program 10th edition 2015, halaman 98-100.

3.12 (Invoice Class)

3.13 (Employee Class)

3.14 (Date Class)


