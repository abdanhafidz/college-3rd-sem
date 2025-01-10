[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/pe1DjBIF)
# pbo-multithreading

## Capaian Pembelajaran

1. Mahasiswa mampu mengimplementasikan multithreading menggunakan interface Runnable dan class Thread untuk melakukan eksekusi paralel.
2. Mahasiswa mampu mengelola dan mensinkronkan thread untuk menghindari kondisi race condition.

## Cara membuka project menggunakan Eclipse IDE

1. Clone repositori project `oop-multithreading` ke local direktori git Anda.
2. Buka Eclipse IDE, Pilih menu File > Import > Maven > Existing Maven Projects.
3. Pada Root Directory, klik tombol Browse, pilih direktori `oop-multithreading`, kemudian check `pom.xml`.
4. Tekan tombol finish untuk melakukan tombol impor.
5. Baca soal dengan seksama. Buat kelas solusi di package `id.its.pbo`.
6. Jalankan unit test dengan cara: klik kanan di project > Run As > JUnit Test / Maven Test.
7. Untuk menjalankan kelas yang memiliki method main. Klik kanan di kelas > Run As > Java Application.

## Soal-soal

### Soal: Simulasi Pabrik Mainan dengan Multithreading

Kerjakan soal berikut di package `id.its.pbo.toys`.

Sebuah pabrik mainan ingin mensimulasikan proses produksi mainan menggunakan beberapa mesin secara bersamaan dengan menggunakan konsep multithreading dalam pemrograman. Setiap mesin memiliki target produksi dan waktu produksi yang berbeda-beda.

#### Deskripsi Kelas

1. **Mesin**
   - Variabel instance: `namaMesin` (String), `waktuProduksi` (int), `jumlahProduksi` (int), `targetProduksi` (int)
   - Konstruktor yang menerima parameter untuk menginisialisasi `namaMesin`, `waktuProduksi`, dan `targetProduksi`.
   - Metode `run()` yang melakukan simulasi produksi mainan dengan mencetak pesan setiap kali selesai memproduksi mainan dan menambahkan `jumlahProduksi`.
   - Metode `getJumlahProduksi()` untuk mendapatkan jumlah mainan yang telah diproduksi oleh mesin tersebut.

2. **PabrikMainan**
   - Variabel instance: `daftarMesinThread` (List<Thread>), `daftarMesin` (List<Mesin>)
   - Metode `tambahMesin(Mesin mesin)` untuk menambahkan mesin ke dalam daftar mesin.
   - Metode `mulaiProduksi()` untuk memulai semua mesin untuk memproduksi mainan secara bersamaan.
   - Metode `getJumlahTotalProduksi()` untuk mendapatkan total mainan yang telah diproduksi oleh semua mesin setelah semua mesin selesai bekerja.

3. **PabrikMainanProgram**
   - Metode static `main` yang melakukan instansiasi objek dari kelas-kelas di atas, menambahkan beberapa mesin ke pabrik, memulai proses produksi, dan mencetak total mainan yang telah diproduksi ke layar setelah semua mesin selesai bekerja.

#### Detail Implementasi

- **Mesin**: Implementasikan `Runnable` dan dalam metode `run()`, gunakan `Thread.sleep(waktuProduksi)` untuk mensimulasikan waktu produksi dan cetak pesan setiap kali mesin selesai memproduksi mainan.

- **PabrikMainan**: Dalam metode `getJumlahTotalProduksi()`, gunakan `threadMesin.join()` untuk menunggu setiap mesin selesai bekerja sebelum menghitung total produksi.

- **PabrikMainanProgram**: Instansiasi beberapa objek mesin dengan kapasitas dan waktu produksi yang berbeda, tambahkan mesin-mesin tersebut ke pabrik, dan mulai proses produksi.

#### Contoh Output
```
Mesin 1 telah memproduksi 1 mainan.
Mesin 2 telah memproduksi 1 mainan.
Mesin 1 telah memproduksi 2 mainan.
Mesin 3 telah memproduksi 1 mainan.
Mesin 1 telah memproduksi 3 mainan.
Mesin 2 telah memproduksi 2 mainan.
Total mainan yang diproduksi: 6
```

#### Catatan
- Pastikan untuk menggunakan konsep threading agar semua mesin dapat bekerja secara bersamaan.
- Setelah semua mesin selesai bekerja, cetak total mainan yang telah diproduksi oleh semua mesin.
- Jangan lupa untuk menangani eksepsi `InterruptedException` yang mungkin terjadi saat menggunakan `Thread.sleep()` dan `thread.join()`.

### Soal: Simulasi Lalu Lintas Jalan

Kerjakan soal berikut di package `id.its.pbo.traffic`.

Sebuah sistem simulasi lalu lintas ingin dibuat untuk menggambarkan interaksi antara beberapa kendaraan di sebuah persimpangan jalan. Setiap kendaraan akan bergerak melintasi persimpangan dan sistem harus memastikan bahwa tidak ada dua kendaraan yang berada di persimpangan pada saat yang sama untuk menghindari tabrakan.

Buatlah kelas-kelas sebagai berikut:

1. **Kendaraan**
   - Variabel instance: `nama` (String), `waktuMelintas` (int)
   - Konstruktor yang menerima parameter untuk menginisialisasi `nama` dan `waktuMelintas`.
   - Metode `melintas()` yang mencetak pesan bahwa kendaraan sedang melintas dan menunggu selama `waktuMelintas` milidetik.
   
   Kendaraan harus mengimplementasikan `Runnable` dan memiliki metode `run` yang memanggil metode `melintas`.

2. **Persimpangan**
   - Variabel instance: `lock` (Object)
   - Metode `melintasiPersimpangan(Kendaraan kendaraan)` yang mencetak pesan bahwa kendaraan sedang melintas dan menunggu selama `waktuMelintas` milidetik.
   
   Metode `melintasiPersimpangan` harus disinkronkan menggunakan `lock` untuk memastikan bahwa hanya satu kendaraan yang dapat melintas pada satu waktu.

3. **SimulasiLaluLintas**
   - Variabel instance: `daftarKendaraan` (List<Thread>)
   - Metode `tambahKendaraan(Kendaraan kendaraan)` untuk menambahkan kendaraan ke dalam simulasi.
   - Metode `mulaiSimulasi()` untuk memulai simulasi dengan menjalankan semua thread kendaraan.
   
4. **SimulasiLaluLintasProgram**
   - Metode static `main` yang melakukan instansiasi objek dari kelas-kelas di atas, menambahkan beberapa kendaraan ke dalam simulasi, dan memulai simulasi.

### Contoh Data:
```
Kendaraan 1: Mobil, waktuMelintas: 1000 ms
Kendaraan 2: Motor, waktuMelintas: 500 ms
Kendaraan 3: Bus, waktuMelintas: 1500 ms
```

### Catatan:
- Kendaraan harus melintas satu per satu untuk menghindari tabrakan.
- Kendaraan yang melintas pertama tidak harus sama dengan kendaraan yang ditambahkan pertama kali ke dalam simulasi.
- Fokus pada penggunaan multithreading dan sinkronisasi untuk menghindari kondisi race condition pada persimpangan.

### Pertanyaan:
- Bagaimana cara memastikan bahwa kendaraan melintas satu per satu?
- Bagaimana jika ada kendaraan yang melintas lebih lama dari kendaraan lainnya, apakah ini akan mempengaruhi urutan kendaraan yang melintas selanjutnya?
- Bagaimana cara menghindari deadlock dalam simulasi ini?

### Output yang diharapkan:
```
Mobil melintas persimpangan...
Mobil telah melintas.
Motor melintas persimpangan...
Motor telah melintas.
Bus melintas persimpangan...
Bus telah melintas.
```

### Output yang salah karena terjadi race condition
```
Mobil melintas persimpangan...
Motor melintas persimpangan...
Bus melintas persimpangan...
Mobil telah melintas.
Bus telah melintas.
Motor telah melintas.
```

Output urutan kendaraan yang melintas tidak harus sesuai contoh output karena tergantung pada thread scheduler.