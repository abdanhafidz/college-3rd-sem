[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/BVJfyaIH)
# pbo-static-members

## Capaian Pembelajaran

1. Mahasiswa mampu menggunakan static members seperti static field maupun static methods sesuai dengan kebutuhan

## Cara membuka project menggunakan Eclipse IDE

1. Clone repositori project `oop-static-members` ke local direktori git Anda.
2. Buka Eclipse IDE, Pilih menu File > Import > Maven > Existing Maven Projects.
3. Pada Root Directory, klik tombol Browse, pilih direktori `oop-static-members`, kemudian check `pom.xml`.
4. Tekan tombol finish untuk melakukan tombol impor.
5. Baca soal dengan seksama. Buat kelas solusi di package `id.its.pbo`.
6. Jalankan unit test dengan cara: klik kanan di project > Run As > JUnit Test / Maven Test.
7. Untuk menjalankan kelas yang memiliki method main. Klik kanan di kelas > Run As > Java Application.

## Soal-soal

### Soal: Penghitung Transaksi

Kerjakan soal berikut di package `id.its.pbo.transaction`.

Sebuah aplikasi perbankan memerlukan sistem untuk menghitung jumlah transaksi yang dilakukan. Setiap transaksi yang dilakukan memiliki ID unik yang bersifat berurutan.

Buatlah sebuah kelas bernama `Transaksi` dengan spesifikasi sebagai berikut:

- Memiliki variabel `static` bernama `counter` yang digunakan untuk menghitung jumlah transaksi yang telah dilakukan.
- Memiliki variabel instance `transaksiID` yang digunakan untuk menyimpan ID dari transaksi tersebut.
- Memiliki variabel instance `jumlah` yang digunakan untuk menyimpan jumlah transaksi.
- Memiliki konstruktor yang menerima parameter `jumlah` dan menginisialisasi variabel instance `jumlah`. Setiap kali objek `Transaksi` dibuat, `counter` akan bertambah dan `transaksiID` akan di-set sesuai dengan nilai `counter` saat itu.
- Memiliki metode `getTransaksiID` yang mengembalikan ID dari transaksi tersebut.
- Memiliki metode `static` `getTotalTransaksi` yang mengembalikan total transaksi yang telah dilakukan.
- Memiliki metode `static` `resetCounter` yang mengatur ulang `counter` menjadi 0.

Buatlah sebuah kelas bernama `TransaksiProgram` yang didalamnya terdapat metode static `main`. Dalam metode `main`, instansiasi beberapa objek dari kelas `Transaksi`, tampilkan ID transaksi dan total transaksi ke layar. Setelah itu, gunakan metode `resetCounter` untuk mengatur ulang penghitung transaksi dan tampilkan kembali total transaksi ke layar.

**Perhatikan:**
1. Pastikan setiap objek `Transaksi` yang dibuat memiliki ID yang unik dan berurutan.
2. Pastikan metode `getTotalTransaksi` mengembalikan jumlah total transaksi yang telah dibuat.

### Soal: Pendaftaran Mahasiswa

Kerjakan soal berikut di package `id.its.pbo.registration`.

Sebuah universitas memerlukan sistem untuk menghitung jumlah mahasiswa yang telah mendaftar. Setiap mahasiswa yang mendaftar akan mendapatkan nomor pendaftaran unik yang bersifat berurutan.

Buatlah sebuah kelas bernama `Mahasiswa` dengan spesifikasi sebagai berikut:

- Memiliki variabel `static` bernama `registrantCounter` yang digunakan untuk menghitung jumlah mahasiswa yang telah mendaftar.
- Memiliki variabel instance `nomorPendaftaran` yang digunakan untuk menyimpan nomor pendaftaran mahasiswa tersebut.
- Memiliki variabel instance `nama` yang digunakan untuk menyimpan nama mahasiswa.
- Memiliki konstruktor yang menerima parameter `nama` dan menginisialisasi variabel instance `nama`. Setiap kali objek `Mahasiswa` dibuat, `registrantCounter` akan bertambah dan `nomorPendaftaran` akan di-set sesuai dengan nilai `registrantCounter` saat itu.
- Memiliki metode `getNomorPendaftaran` yang mengembalikan nomor pendaftaran mahasiswa tersebut.
- Memiliki metode `static` `getTotalRegistrant` yang mengembalikan total mahasiswa yang telah mendaftar.
- Memiliki metode `static` `resetRegistrantCounter` yang mengatur ulang `registrantCounter` menjadi 0.

Buatlah sebuah kelas bernama `PendaftaranProgram` yang didalamnya terdapat metode static `main`. Dalam metode `main`, instansiasi beberapa objek dari kelas `Mahasiswa`, tampilkan nomor pendaftaran dan total mahasiswa yang telah mendaftar ke layar. Setelah itu, gunakan metode `resetRegistrantCounter` untuk mengatur ulang penghitung pendaftaran dan tampilkan kembali total mahasiswa yang telah mendaftar ke layar.

