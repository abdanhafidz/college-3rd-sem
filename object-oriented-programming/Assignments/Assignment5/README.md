[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/aVqsd9nv)
# pbo-interface

## Capaian Pembelajaran

1. Mahasiswa mampu menggunakan interface
2. Mahasiswa mampu menggunakan abstract class dan interface pada situasi yang berbeda

## Cara membuka project menggunakan Eclipse IDE

1. Clone repositori project `oop-interface` ke local direktori git Anda.
2. Buka Eclipse IDE, Pilih menu File > Import > Maven > Existing Maven Projects.
3. Pada Root Directory, klik tombol Browse, pilih direktori `oop-interface`, kemudian check `pom.xml`.
4. Tekan tombol finish untuk melakukan tombol impor.
5. Baca soal dengan seksama. Buat kelas solusi di package id.its.pbo.
6. Jalankan unit test dengan cara: klik kanan di project > Run As > JUnit Test / Maven Test.
7. Untuk menjalankan kelas yang memiliki method main. Klik kanan di kelas > Run As > Java Application.

## Soal-soal

### Soal: Kebun Binatang

Kerjakan soal berikut di package `id.its.pbo.zoo`.

Sebuah kebun binatang memiliki berbagai jenis hewan. Beberapa hewan di kebun binatang tersebut dapat melakukan aksi khusus, seperti mengeluarkan suara.

Buatlah sebuah interface bernama `BisaBersuara` yang memiliki informasi sebagai berikut:
- Metode `suara` yang mengembalikan suara dari hewan tersebut.

Buatlah kelas abstrak `Hewan` dengan variabel instance `nama` (tipe String) dan metode `getNama` untuk mengembalikan nama hewan.

Dari kelas `Hewan`, turunkan tiga kelas yaitu `Singa`, `Kuda`, dan `Ular`. 
- Kelas `Singa` mengimplementasi interface `BisaBersuara` dan ketika memanggil metode `suara` akan mengembalikan "Roar".
- Kelas `Kuda` mengimplementasi interface `BisaBersuara` dan ketika memanggil metode `suara` akan mengembalikan "Neigh".
- Kelas `Ular` tidak mengimplementasi interface `BisaBersuara` karena ular tidak mengeluarkan suara yang khas.

Buatlah sebuah kelas bernama `KebunBinatang` yang memiliki informasi sebagai variabel instance berupa daftar hewan (tipe List<Hewan>). Kelas `KebunBinatang` harus memiliki metode untuk menambahkan hewan ke dalam daftar dengan nama `tambahHewan`, dan metode `tampilkanHewanBersuara` yang menampilkan hanya hewan-hewan yang bisa bersuara.

Buatlah sebuah kelas bernama `KebunBinatangProgram` yang didalamnya terdapat metode static `main`. Instansiasi objek dari kelas `KebunBinatang`, tambahkan beberapa hewan ke dalam daftar, dan tampilkan hewan-hewan yang bisa bersuara ke layar dengan memanggil metode `tampilkanHewanBersuara`.

### Soal: Toko Barang

Kerjakan soal berikut di package `id.its.pbo.shops`.

Sebuah toko menjual berbagai jenis barang, termasuk barang elektronik dan mobil listrik. Beberapa barang memerlukan sumber listrik untuk dapat berfungsi.

Buatlah sebuah interface bernama `Electrifiable` yang memiliki informasi sebagai berikut:
- Metode `powerOn` yang digunakan untuk menyalakan perangkat.
- Metode `powerOff` yang digunakan untuk mematikan perangkat.

Buatlah kelas abstrak `Barang` dengan variabel instance `merk` (tipe String) dan metode `getMerk` untuk mengembalikan merk barang.

Dari kelas `Barang`, turunkan tiga kelas yaitu `Televisi`, `KipasAngin`, dan `MobilListrik`. 
- Kelas `Televisi` mengimplementasi interface `Electrifiable` dan ketika memanggil metode `powerOn` akan mengembalikan "Televisi dinyalakan", dan `powerOff` akan mengembalikan "Televisi dimatikan".
- Kelas `KipasAngin` mengimplementasi interface `Electrifiable` dan ketika memanggil metode `powerOn` akan mengembalikan "Kipas Angin dinyalakan", dan `powerOff` akan mengembalikan "Kipas Angin dimatikan".
- Kelas `MobilListrik` mengimplementasi interface `Electrifiable` dan ketika memanggil metode `powerOn` akan mengembalikan "Mobil Listrik siap berjalan", dan `powerOff` akan mengembalikan "Mobil Listrik berhenti".

Buatlah sebuah kelas bernama `ElectricityProvider` yang memiliki metode static `supplyPower` yang menerima parameter objek yang mengimplementasi interface `Electrifiable` dan menyalakan perangkat tersebut.

Buatlah sebuah kelas bernama `TokoBarangProgram` yang didalamnya terdapat metode static `main`. Instansiasi objek dari kelas `Televisi`, `KipasAngin`, dan `MobilListrik`, kemudian gunakan `ElectricityProvider` untuk menyuplai listrik ke perangkat tersebut dan tampilkan ke layar.

### Soal: Urutan Barang

Kerjakan soal berikut di package `id.its.pbo.sorting`.

Sebuah aplikasi digunakan untuk mengurutkan berbagai jenis barang berdasarkan kriteria tertentu. Beberapa barang dapat diurutkan, tetapi tidak semuanya.

Buatlah sebuah interface bernama `Sortable` yang memiliki informasi sebagai berikut:
- Metode `compare` yang mengembalikan nilai (tipe int). Jika objek yang dicompare lebih kecil urutannya maka return -1, jika sama urutannya return 0, jika lebih besar maka return 1.

Buatlah kelas abstrak `Item` dengan variabel instance `nama` (tipe String) dan metode `getNama` untuk mengembalikan nama item.

Dari kelas `Item`, turunkan tiga kelas yaitu `Buku`, `Sepatu`, dan `Makanan`. 
- Kelas `Buku` memiliki variabel instance tambahan yaitu `jumlahHalaman` (tipe int). Kelas `Buku` mengimplementasi interface `Sortable` dan metode `compare` akan membandingkan berdasarkan `jumlahHalaman`.
- Kelas `Sepatu` memiliki variabel instance tambahan yaitu `ukuran` (tipe int). Kelas `Sepatu` mengimplementasi interface `Sortable` dan metode `compare` akan membandingkan berdasarkan `ukuran`.
- Kelas `Makanan` hanya memiliki variabel instance `nama` dan tidak mengimplementasi interface `Sortable`.

Buatlah sebuah kelas bernama `Sorter` yang memiliki metode static `sortItems` yang menerima parameter berupa array dari objek yang mengimplementasi interface `Sortable` dan mengembalikan array yang sudah diurutkan berdasarkan metode `compare`.

Buatlah sebuah kelas bernama `SortingProgram` yang didalamnya terdapat metode static `main`. Instansiasi objek dari kelas `Buku` dan `Sepatu`, kemudian gunakan `Sorter` untuk mengurutkan item-item tersebut dan tampilkan hasil pengurutan ke layar.