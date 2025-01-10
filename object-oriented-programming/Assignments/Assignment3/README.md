[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/s0HpSuXt)
# pbo-inheritance

## Capaian Pembelajaran

Mahasiswa mampu memodelkan struktur composition

## Cara membuka project menggunakan Eclipse IDE

1. Clone repositori project `oop-composition` ke local direktori git Anda.
2. Buka Eclipse IDE, Pilih menu File > Import > Maven > Existing Maven Projects.
3. Pada Root Directory, klik tombol Browse, pilih direktori `oop-composition`, kemudian check `pom.xml`.
4. Tekan tombol finish untuk melakukan tombol impor.
5. Baca soal dengan seksama. Buat kelas solusi di package `id.its.pbo`.
6. Jalankan unit test dengan cara: klik kanan di project > Run As > JUnit Test / Maven Test.
7. Untuk menjalankan kelas yang memiliki method main. Klik kanan di kelas > Run As > Java Application.

## Soal-soal

### Komputer dan Komponennya

Kerjakan soal berikut di package `id.its.pbo.computer`.

Buatlah sebuah kelas bernama `Komputer` yang digunakan untuk merepresentasikan sebuah komputer. Sebuah `Komputer` memiliki komponen-komponen sebagai variabel instance yaitu: `Processor` (tipe Processor) dan `Memory` (tipe Memory).

Buatlah kelas `Processor` dengan informasi sebagai variabel instance yaitu: `brand` (tipe String) dan `kecepatan` (tipe double, dalam GHz). Kelas `Processor` harus memiliki konstruktor yang menginisialisasi kedua variabel instance tersebut serta metode setter dan getter untuk masing-masing variabel instance.

Buatlah kelas `Memory` dengan informasi sebagai variabel instance yaitu: `kapasitas` (tipe int, dalam GB) dan `tipeMemory` (tipe String, seperti "DDR4", "DDR5"). Kelas `Memory` harus memiliki konstruktor yang menginisialisasi kedua variabel instance tersebut serta metode setter dan getter untuk masing-masing variabel instance.

Kelas `Komputer` harus memiliki konstruktor yang menginisialisasi kedua komponen tersebut. Sediakan metode setter dan getter untuk masing-masing komponen. Kelas `Komputer` juga memiliki metode `infoKomputer` yang mengembalikan informasi komputer dengan memanfaatkan informasi dari kelas Processor dan Memory dengan format "Processor Brand: [Brand], Kecepatan: [Kecepatan], Memory Kapasitas: [Kapasitas], Tipe: [TipeMemory]".

Buatlah sebuah kelas bernama `KomputerProgram` yang didalamnya terdapat metode static main. Instansiasi 1 objek dari kelas Komputer menggunakan keyword new, set variabel instancenya, dan tampilkan informasi dari komputer tersebut ke layar.

### Toko Buku

Kerjakan soal berikut di package `id.its.pbo.store`.

Buatlah sebuah kelas bernama `Buku` yang digunakan untuk merepresentasikan sebuah buku yang dijual di toko buku. Sebuah `Buku` memiliki tiga informasi sebagai variabel instance yaitu: isbn (tipe String), judul (tipe String) dan harga (tipe double). Kelas Buku harus memiliki sebuah konstruktor yang menginisialisasi ketiga variabel instance tersebut. Sediakan metode setter dan getter public untuk masing-masing variabel instance yaitu `isbn`, `judul`, dan `harga`.

Buatlah sebuah kelas bernama `TokoBuku` yang memiliki informasi sebagai variabel instance berupa daftar buku (tipe List<Buku>). Kelas `TokoBuku` harus memiliki metode untuk menambahkan buku ke dalam daftar dengan nama `tambahBuku`, menghapus buku dari daftar dengan nama `hapusBuku`, mencari buku berdasarkan ISBN dengan nama `cariBuku` dan menampilkan semua buku yang ada di daftar dengan nama `getDaftarBuku`.

Buatlah sebuah kelas bernama `TokoBukuProgram` yang didalamnya terdapat metode static main. Instansiasi objek dari kelas TokoBuku, tambahkan beberapa buku ke dalam daftar, hapus beberapa buku, dan tampilkan informasi dari semua buku yang ada di daftar ke layar.

### Toko Elektronik

Kerjakan soal berikut di package `id.its.pbo.electronics`.

Sebuah toko elektronik menjual berbagai jenis produk. Setiap produk memiliki karakteristik harga dan nama.

Buatlah sebuah kelas bernama `Produk` yang memiliki informasi sebagai variabel instance yaitu: nama (tipe String) dan harga (tipe double). Kelas `Produk` harus memiliki sebuah konstruktor yang menginisialisasi kedua variabel instance tersebut. Sediakan metode setter dan getter public untuk masing-masing variabel instance yaitu `nama` dan `harga`.

Buatlah sebuah kelas bernama `ItemBelanja` yang merepresentasikan sebuah item dalam keranjang belanja. Kelas ini memiliki dua variabel instance yaitu: produk (tipe Produk) dan kuantitas (tipe int). Kelas `ItemBelanja` harus memiliki metode `hitungTotal` yang mengembalikan total harga dari produk berdasarkan kuantitasnya.

Buatlah sebuah kelas bernama `KeranjangBelanja` yang memiliki informasi sebagai variabel instance berupa daftar item belanja (tipe List<ItemBelanja>). Kelas `KeranjangBelanja` harus memiliki metode untuk menambahkan produk ke dalam daftar dengan nama `tambahProduk` dan metode `hitungTotalBelanja` yang mengembalikan nilai bertipe double yang merupakan total harga dari semua produk yang ada di dalam daftar.

Buatlah sebuah kelas bernama `TokoElektronikProgram` yang didalamnya terdapat metode static `main`. Instansiasi objek dari kelas `KeranjangBelanja`, tambahkan beberapa produk ke dalam daftar, dan tampilkan total harga dari semua produk yang ada di daftar ke layar dengan memanggil metode `hitungTotalBelanja`.

