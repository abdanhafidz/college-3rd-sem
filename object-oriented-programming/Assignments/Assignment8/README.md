[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/XfDKafKG)
# pbo-exception

## Capaian Pembelajaran

1. Mahasiswa mampu mengimplementasikan alur tidak normal menggunakan mekanisme exception throwing.
2. Mahasiswa mampu mengimplementasikan penanganan error menggunakan konstruksi try-catch.
3. Mahasiswa mampu mengimplementasikan custom exception.


## Cara membuka project menggunakan Eclipse IDE

1. Clone repositori project `oop-exception` ke local direktori git Anda.
2. Buka Eclipse IDE, Pilih menu File > Import > Maven > Existing Maven Projects.
3. Pada Root Directory, klik tombol Browse, pilih direktori `oop-exception`, kemudian check `pom.xml`.
4. Tekan tombol finish untuk melakukan tombol impor.
5. Baca soal dengan seksama. Buat kelas solusi di package `id.its.pbo`.
6. Jalankan unit test dengan cara: klik kanan di project > Run As > JUnit Test / Maven Test.
7. Untuk menjalankan kelas yang memiliki method main. Klik kanan di kelas > Run As > Java Application.

## Soal-soal

### Soal: Pengecekan Akun Bank

Kerjakan soal berikut di package `id.its.pbo.bank`.

Sebuah bank memiliki sistem untuk mengecek saldo dan melakukan penarikan uang dari akun pelanggan. Namun, terkadang terjadi kesalahan seperti saldo tidak mencukupi atau akun tidak ditemukan.

Buatlah kelas custom exception sebagai berikut:
1. `SaldoTidakCukupException` yang mengembalikan pesan "Saldo tidak mencukupi!"
2. `AkunTidakDitemukanException` yang mengembalikan pesan "Akun tidak ditemukan!"
3. `BatasPenarikanException` yang mengembalikan pesan "Melebihi batas penarikan harian."

Buatlah kelas `AkunBank` dengan variabel instance sebagai berikut:
- `nomorAkun` (tipe String)
- `saldo` (tipe double)

Kelas `AkunBank` harus memiliki metode:
- `penarikan(double jumlah)` yang mengurangi saldo dengan jumlah yang diberikan. Jika saldo tidak mencukupi, lemparkan `SaldoTidakCukupException`. Jika jumlah yang ditarik lebih dari batas penarikan harian sebesar 100000, maka lemparkan `BatasPenarikanException`. Simpan nilai batas penarikan harian dalam sebuah variabel konstan static.
- `getSaldo()` yang mengembalikan saldo saat ini.

Buatlah kelas `Bank` dengan variabel instance berupa daftar akun (tipe List<AkunBank>). Kelas `Bank` harus memiliki metode:
- `tambahAkun(AkunBank akun)` untuk menambahkan akun ke daftar.
- `cariAkun(String nomorAkun)` untuk mencari akun berdasarkan nomor akun. Jika akun tidak ditemukan, lemparkan `AkunTidakDitemukanException`.

Buatlah kelas `BankProgram` yang didalamnya terdapat metode static `main`. Dalam metode `main`, coba tambahkan beberapa akun ke bank, lakukan penarikan, dan tangani kemungkinan exception yang mungkin terjadi.

**Catatan**: Pastikan untuk menggunakan blok try-catch untuk menangani exception yang mungkin terjadi saat menjalankan program.

### Soal: Pendaftaran Kursus Online

Kerjakan soal berikut di package `id.its.pbo.course`.

Sebuah platform kursus online membatasi pendaftaran kursus berdasarkan usia dan tingkat pendidikan peserta. Terdapat beberapa kesalahan yang mungkin terjadi saat seseorang mencoba mendaftar. Selain itu, sistem juga mencatat setiap aktivitas pendaftaran, baik berhasil maupun gagal.

Buatlah kelas custom exception sebagai berikut:
1. `UsiaTidakMemenuhiSyaratException` yang mengembalikan pesan "Maaf, usia Anda tidak memenuhi syarat untuk mengikuti kursus ini."
2. `PendidikanTidakMemenuhiSyaratException` yang mengembalikan pesan "Maaf, tingkat pendidikan Anda tidak memenuhi syarat untuk mengikuti kursus ini."

Buatlah kelas `Peserta` dengan variabel instance sebagai berikut:
- `nama` (tipe String)
- `usia` (tipe int)
- `tingkatPendidikan` (tipe String)

Kelas `Peserta` harus memiliki metode:
- `cekKelayakan()` yang memeriksa apakah peserta memenuhi syarat untuk mendaftar. Jika usia kurang dari 18 tahun, lemparkan `UsiaTidakMemenuhiSyaratException`. Jika tingkat pendidikan bukan "Sarjana" atau "Magister", lemparkan `PendidikanTidakMemenuhiSyaratException`.

Buatlah kelas `KursusOnline` dengan variabel instance berupa daftar peserta (tipe List<Peserta>). Kelas `KursusOnline` harus memiliki metode:
- `daftarPeserta(Peserta peserta)` untuk menambahkan peserta ke daftar kursus setelah memeriksa kelayakannya.
- `getDaftarPeserta()` untuk mendapatkan daftar peserta yang telah mendaftar.

Buatlah kelas `KursusProgram` yang didalamnya terdapat metode static `main`. Dalam metode `main`, coba daftarkan beberapa peserta ke kursus online. Tangani kemungkinan exception yang mungkin terjadi saat pendaftaran dengan blok try-catch. Di dalam blok `finally`, cetak pesan "Proses pendaftaran selesai." untuk menandakan bahwa proses pendaftaran telah selesai, baik berhasil maupun gagal.

**Catatan**: Pastikan untuk menggunakan blok try-catch-finally saat mendaftarkan peserta untuk menangani exception yang mungkin terjadi dan mencetak pesan di blok `finally`.

### Soal: Pemeriksaan Data Pasien

Kerjakan soal berikut di package `id.its.pbo.medical`.

Sebuah aplikasi kesehatan digunakan untuk memeriksa data pasien. Terdapat beberapa kesalahan yang mungkin terjadi saat seseorang mencoba memasukkan data. Selain itu, sistem juga mencatat setiap aktivitas pemeriksaan, baik berhasil maupun gagal.

Buatlah kelas custom exception sebagai berikut:
1. `DataTidakLengkapException` yang mengembalikan pesan "Data pasien tidak lengkap."
2. `DataTidakValidException` yang mengembalikan pesan "Data yang dimasukkan tidak valid."

Buatlah kelas `Pasien` dengan variabel instance sebagai berikut:
- `nama` (tipe String)
- `umur` (tipe int)
- `alamat` (tipe String)

Kelas `Pasien` harus memiliki metode:
- `validasiData()` yang memeriksa apakah data pasien valid. Jika nama atau alamat kosong, lemparkan `DataTidakLengkapException`. Jika umur kurang dari 0 atau lebih dari 120, lemparkan `DataTidakValidException`.

Buatlah kelas `Pemeriksaan` dengan metode:
- `periksaData(Pasien pasien)` yang memeriksa validitas data pasien. Jika terjadi exception saat validasi, tangkap exception tersebut dan lemparkan kembali dengan pesan yang lebih spesifik.

Buatlah kelas `PemeriksaanProgram` yang didalamnya terdapat metode static `main`. Dalam metode `main`, coba periksa beberapa data pasien. Tangani kemungkinan exception yang mungkin terjadi saat pemeriksaan dengan blok try-catch. Di dalam blok `catch`, cetak pesan kesalahan yang diterima dari `periksaData`.

**Catatan**: Pastikan untuk menggunakan blok try-catch saat memeriksa data pasien untuk menangani exception yang mungkin terjadi dan mencetak pesan kesalahan yang spesifik. Fokus pada mekanisme rethrowing exception untuk memberikan informasi yang lebih spesifik tentang kesalahan yang terjadi.