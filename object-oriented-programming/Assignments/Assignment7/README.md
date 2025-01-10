[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/iyMwmQLP)
# pbo-constructor-calling-chain

## Capaian Pembelajaran

1. Mahasiswa mampu memanfaatkan constructor untuk menginisialisasi instance variable di dalam satu hirarki inheritance

## Cara membuka project menggunakan Eclipse IDE

1. Clone repositori project `oop-constructor-calling-chain` ke local direktori git Anda.
2. Buka Eclipse IDE, Pilih menu File > Import > Maven > Existing Maven Projects.
3. Pada Root Directory, klik tombol Browse, pilih direktori `oop-constructor-calling-chain`, kemudian check `pom.xml`.
4. Tekan tombol finish untuk melakukan tombol impor.
5. Baca soal dengan seksama. Buat kelas solusi di package `id.its.pbo`.
6. Jalankan unit test dengan cara: klik kanan di project > Run As > JUnit Test / Maven Test.
7. Untuk menjalankan kelas yang memiliki method main. Klik kanan di kelas > Run As > Java Application.

## Soal-soal

### Soal: Hierarki Karyawan

Kerjakan soal berikut di package `id.its.pbo.perusahaan`.

Sebuah perusahaan memiliki beberapa jenis karyawan dengan karakteristik dan detail yang berbeda-beda. Setiap karyawan memiliki beberapa informasi dasar dan beberapa informasi tambahan tergantung pada jenis karyawan tersebut.

Buatlah kelas `Karyawan` dengan informasi sebagai berikut:
- `nama` (tipe String): Nama dari karyawan.
- `id` (tipe String): ID karyawan.
Kelas `Karyawan` harus memiliki konstruktor yang menerima parameter untuk menginisialisasi variabel-variabel instance tersebut.

Dari kelas `Karyawan`, turunkan kelas `Manager` yang memiliki informasi tambahan sebagai berikut:
- `departemen` (tipe String): Nama departemen yang dikelola oleh manager tersebut.
Kelas `Manager` harus memiliki konstruktor yang menerima parameter untuk menginisialisasi semua variabel instance (termasuk yang diwarisi dari `Karyawan`) dan memanggil konstruktor dari kelas induknya.

Dari kelas `Manager`, turunkan kelas `Direktur` yang memiliki informasi tambahan sebagai berikut:
- `gaji` (tipe double): Gaji yang diterima oleh direktur tersebut.
Kelas `Direktur` harus memiliki konstruktor yang menerima parameter untuk menginisialisasi semua variabel instance (termasuk yang diwarisi dari `Manager` dan `Karyawan`) dan memanggil konstruktor dari kelas induknya.

Buatlah kelas `Perusahaan` dengan metode `main` yang melakukan hal berikut:
- Membuat objek dari kelas `Direktur` dengan menginisialisasi semua informasi yang dibutuhkan.
- Mencetak informasi dari objek direktur tersebut ke layar.

**Catatan**: Fokus pada penggunaan constructor calling chain untuk menginisialisasi variabel-variabel instance pada setiap kelas dalam hierarki pewarisan. Pastikan setiap kelas memanggil konstruktor dari kelas induknya untuk menginisialisasi variabel-variabel yang diwarisi.

### Soal: Sistem Informasi Perpustakaan

Kerjakan soal berikut di package `id.its.pbo.library`.

Sebuah perpustakaan ingin membuat sistem informasi untuk mengelola data buku dan anggota. Setiap buku memiliki beberapa informasi dasar dan setiap anggota memiliki beberapa data pribadi. Selain itu, perpustakaan ingin mencatat siapa saja yang pernah meminjam buku tersebut.

Buatlah kelas-kelas sebagai berikut:

1. **Buku**
   - Variabel instance: `judul` (String), `pengarang` (String), `tahunTerbit` (int), `daftarPeminjam` (List<Anggota>)
   - Konstruktor yang menerima parameter untuk menginisialisasi `judul`, `pengarang`, dan `tahunTerbit`.
   - Metode `tambahPeminjam(Anggota anggota)` untuk menambahkan anggota ke dalam daftar peminjam.
   - Metode `getDaftarPeminjam()` untuk mendapatkan daftar peminjam.
   - Metode `getInfoBuku()` untuk mendapatkan informasi buku dalam format: "[judul], [pengarang], [tahunTerbit]".

2. **Anggota**
   - Variabel instance: `nama` (String), `alamat` (String), `nomorAnggota` (String)
   - Konstruktor yang menerima parameter untuk menginisialisasi `nama` dan `nomorAnggota`. Alamat diinisialisasi dengan "Alamat belum diisi".
   - Konstruktor yang menerima parameter untuk menginisialisasi `nama`, `alamat`, dan `nomorAnggota`.
   - Metode `getInfoAnggota()` untuk mendapatkan informasi anggota dalam format: "[nama], [alamat], [nomorAnggota]".

3. **Perpustakaan**
   - Variabel instance: `daftarBuku` (List<Buku>), `daftarAnggota` (List<Anggota>)
   - Metode `tambahBuku(Buku buku)` untuk menambahkan buku ke dalam daftar buku.
   - Metode `tambahAnggota(Anggota anggota)` untuk menambahkan anggota ke dalam daftar anggota.
   - Metode `pinjamBuku(Anggota anggota, Buku buku)` untuk menambahkan anggota ke dalam daftar peminjam buku.
   - Metode `getDaftarBuku()` untuk mendapatkan daftar buku.
   - Metode `getDaftarAnggota()` untuk mendapatkan daftar anggota.

4. **PerpustakaanProgram**
   - Metode static `main` yang melakukan instansiasi objek dari kelas-kelas di atas, menambahkan beberapa buku dan anggota, serta mencetak informasi buku dan anggota ke layar.

### Contoh Data:
```
Info Buku:
- Harry Potter, J.K. Rowling, 1997
- The Hobbit, J.R.R. Tolkien, 1937

Info Anggota:
- Alice, Alamat belum diisi, A001
- Bob, Jl. Merdeka No. 1, B002

Daftar Peminjam Buku "Harry Potter":
- Alice, Alamat belum diisi, A001
```