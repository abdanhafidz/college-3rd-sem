[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/UtmTwYL7)
# pbo-inheritance

## Capaian Pembelajaran

Mahasiswa mampu memodelkan struktur inheritance

## Cara membuka project menggunakan Eclipse IDE

1. Clone repositori project `oop-inheritance` ke local direktori git Anda.
2. Buka Eclipse IDE, Pilih menu File > Import > Maven > Existing Maven Projects.
3. Pada Root Directory, klik tombol Browse, pilih direktori `oop-inheritance`, kemudian check `pom.xml`.
4. Tekan tombol finish untuk melakukan tombol impor.
5. Baca soal dengan seksama. Buat kelas solusi di package `id.its.pbo`.
6. Jalankan unit test dengan cara: klik kanan di project > Run As > JUnit Test / Maven Test.
7. Untuk menjalankan kelas yang memiliki method main. Klik kanan di kelas > Run As > Java Application.

## Soal-soal

### Book

Kerjakan soal berikut di package `id.its.pbo.book`.

Buatlah sebuah kelas bernama `Buku` yang digunakan oleh sebuah perpustakaan untuk merepresentasikan sebuah buku yang tersedia di perpustakaan tersebut. Sebuah `Buku` memiliki dua informasi sebagai variabel instance yaitu: judul (tipe String) dan pengarang (tipe String). Kelas `Buku` harus memiliki sebuah konstruktor yang menginisialisasi kedua variabel instance tersebut. Sediakan metode setter dan getter public untuk masing-masing variabel instance yaitu `judul` dan `pengarang`.

Dari kelas `Buku`, turunkan dua kelas yaitu `BukuFiksi` dan `BukuPelajaran`. Kelas `BukuFiksi` memiliki tambahan informasi sebagai variabel instance yaitu: `genre` (tipe String, seperti "Fantasi", "Horor", dll.). Sedangkan kelas `BukuPelajaran` memiliki tambahan informasi sebagai variabel instance yaitu: `subjek` (tipe String, seperti "Matematika", "Biologi", dll.). Masing-masing kelas turunan harus memiliki konstruktor yang menginisialisasi semua variabel instance, termasuk yang diwariskan dari kelas `Buku`. Sediakan metode setter dan getter public untuk masing-masing variabel instance tambahan yaitu `genre` untuk `BukuFiksi` dan `subjek` untuk `BukuPelajaran`.

Buatlah sebuah kelas bernama `PerpustakaanProgram` yang didalamnya terdapat metode static main. Instansiasi 1 objek dari kelas `BukuFiksi` dan 1 objek dari kelas `BukuPelajaran` menggunakan keyword new, set variabel instancenya, dan tampilkan informasi dari kedua buku tersebut ke layar.

### Vehicle

Kerjakan soal berikut di package `id.its.pbo.vehicle`.

Buatlah sebuah kelas bernama `Kendaraan` yang digunakan untuk merepresentasikan sebuah kendaraan. Sebuah Kendaraan memiliki dua informasi sebagai variabel instance yaitu: merk (tipe String) dan tahunProduksi (tipe int). Kelas `Kendaraan` harus memiliki sebuah konstruktor yang menginisialisasi kedua variabel instance tersebut. Pastikan variabel instance yaitu `merk` dan `tahunProduksi` dapat diakses di kelas turunan tanpa mengakses metode getter yang public. Kelas Kendaraan juga memiliki sebuah metode protected `infoKendaraan` yang mengembalikan informasi kendaraan dalam format "Merk: [merk], Tahun: [tahunProduksi]".

Dari kelas Kendaraan, turunkan kelas `Mobil` yang berada di package `id.its.pbo.transport`. Kelas Mobil memiliki tambahan informasi sebagai variabel instance yaitu: jenis (tipe String, seperti "SUV", "Sedan", dll.). Kelas Mobil harus memiliki konstruktor yang menginisialisasi semua variabel instance, termasuk yang diwariskan dari kelas Kendaraan. Sediakan metode setter dan getter public untuk variabel instance tambahan yaitu `jenis`. Kelas Mobil juga memiliki metode `infoMobil` yang mengembalikan informasi mobil dengan memanfaatkan metode `infoKendaraan` dari kelas `Kendaraan` dan menambahkannya dengan informasi jenis mobil.

Buatlah sebuah kelas bernama `KendaraanProgram` yang didalamnya terdapat metode static main. Instansiasi 1 objek dari kelas Mobil menggunakan keyword new, set variabel instancenya, dan tampilkan informasi dari mobil tersebut ke layar.


### Smartphone

Kerjakan soal berikut di package `id.its.pbo.gadget`.

Buatlah sebuah kelas bernama `Gadget` yang digunakan untuk merepresentasikan sebuah gadget. Sebuah `Gadget` memiliki dua informasi sebagai variabel instance yaitu: brand (tipe String) dan tahunRilis (tipe int). Kelas `Gadget` harus memiliki sebuah konstruktor yang menginisialisasi kedua variabel instance tersebut. Pastikan variabel instance yaitu `brand` dan `tahunRilis` dapat diakses di kelas turunan tanpa mengakses metode getter yang public. Kelas `Gadget` juga memiliki sebuah metode protected `infoGadget` yang mengembalikan informasi gadget dalam format "Brand: [brand], Tahun Rilis: [tahunRilis]".

Dari kelas `Gadget`, turunkan kelas `Smartphone` yang berada di package `id.its.pbo.electronics`. Kelas `Smartphone` memiliki tambahan informasi sebagai variabel instance yaitu: sistemOperasi (tipe String, seperti "Android", "iOS", dll.). Kelas `Smartphone` harus memiliki konstruktor yang menginisialisasi semua variabel instance, termasuk yang diwariskan dari kelas `Gadget`. Sediakan metode setter dan getter public untuk variabel instance tambahan yaitu `sistemOperasi`. Kelas `Smartphone` juga memiliki metode `infoSmartphone` yang mengembalikan informasi smartphone dengan memanfaatkan metode `infoGadget` dari kelas Gadget dan menambahkannya dengan informasi sistem operasi smartphone dalam format "Brand: [brand], Tahun Rilis: [tahunRilis], Sistem Operasi: [sistemOperasi]".

Buatlah sebuah kelas bernama GadgetProgram yang didalamnya terdapat metode static main. Instansiasi 1 objek dari kelas `Smartphone` menggunakan keyword new, set variabel instancenya, dan tampilkan informasi dari smartphone tersebut ke layar.

