[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/mxvMwRQp)
# pbo-polymorphism

## Capaian Pembelajaran

1. Mahasiswa mampu mengimplementasikan prinsip polymorphism
2. Mahasiswa mampu menggunakan abstract class sesuai dengan kebutuhan

## Cara membuka project menggunakan Eclipse IDE

1. Clone repositori project `oop-polymorphism` ke local direktori git Anda.
2. Buka Eclipse IDE, Pilih menu File > Import > Maven > Existing Maven Projects.
3. Pada Root Directory, klik tombol Browse, pilih direktori `oop-polymorphism`, kemudian check `pom.xml`.
4. Tekan tombol finish untuk melakukan tombol impor.
5. Baca soal dengan seksama. Buat kelas solusi di package id.its.pbo.
6. Jalankan unit test dengan cara: klik kanan di project > Run As > JUnit Test / Maven Test.
7. Untuk menjalankan kelas yang memiliki method main. Klik kanan di kelas > Run As > Java Application.

## Soal-soal

### Hewan dan Suara

Kerjakan soal berikut di package `id.its.pbo.zoo`.

Buatlah sebuah kelas abstrak bernama `Hewan` yang digunakan untuk merepresentasikan hewan di kebun binatang. Sebuah Hewan memiliki satu informasi sebagai variabel instance yaitu: nama (tipe String). Kelas `Hewan` harus memiliki sebuah konstruktor yang menginisialisasi variabel instance tersebut. Sediakan metode setter dan getter public untuk variabel instance yaitu `nama`. Kelas Hewan juga memiliki sebuah metode abstrak `buatSuara` yang akan mengembalikan suara dari hewan tersebut.

Dari kelas `Hewan`, turunkan dua kelas yaitu `Kucing` dan `Anjing`. Kelas `Kucing` mengembalikan suara "Meong" saat metode `buatSuara` dipanggil. Sedangkan kelas `Anjing` mengembalikan suara "Guk" saat metode `buatSuara` dipanggil.

Buatlah sebuah kelas bernama `KebunBinatangProgram` yang didalamnya terdapat metode static `main`. Instansiasi objek dari kelas Kucing dan Anjing, kemudian tampilkan suara dari kedua hewan tersebut ke layar.


### Studio Musik

Kerjakan soal berikut di package `id.its.pbo.music`.

Sebuah studio musik memiliki berbagai jenis instrumen. Setiap instrumen memiliki karakteristik suaranya masing-masing.

Buatlah sebuah kelas abstrak bernama `Instrumen` yang memiliki informasi sebagai variabel instance yaitu: nama (tipe String). Kelas Instrumen harus memiliki sebuah konstruktor yang menginisialisasi variabel instance tersebut dan metode abstrak `suara` yang mengembalikan suara dari instrumen tersebut.

Dari kelas `Instrumen`, turunkan dua kelas yaitu `Gitar` dan `Piano`. Kelas `Gitar` ketika memainkan metode `suara` akan mengembalikan "tring tring", sedangkan kelas `Piano` akan mengembalikan "tink tink".

Buatlah sebuah kelas bernama `StudioMusik` yang memiliki informasi sebagai variabel instance berupa array instrumen (tipe List<Instrumen>). Kelas `StudioMusik` harus memiliki metode untuk menambahkan instrumen ke dalam array dengan nama `tambahInstrumen`, dan metode `mainkanInstrumen` yang mengembalikan nilai bertipe string yang merupakan gabungan seluruh suara instrumen yang ada di dalam array.

Buatlah sebuah kelas bernama `StudioMusikProgram` yang didalamnya terdapat metode static `main`. Instansiasi objek dari kelas `StudioMusik`, tambahkan beberapa instrumen ke dalam daftar, dan tampilkan informasi dari semua instrumen yang ada di daftar ke layar dengan memanggil metode `mainkanInstrumen`.

### Soal: Studio Seni

Kerjakan soal berikut di package `id.its.pbo.art`.

Sebuah studio seni memiliki berbagai jenis karya seni. Setiap karya seni memiliki deskripsi dan cara khas untuk menampilkan karyanya.

Buatlah sebuah kelas abstrak bernama `KaryaSeni` yang memiliki informasi sebagai variabel instance yaitu: judul (tipe String). Kelas `KaryaSeni` harus memiliki sebuah konstruktor yang menginisialisasi variabel instance tersebut dan metode abstrak `deskripsi` yang mengembalikan deskripsi dari karya seni tersebut serta metode abstrak `tampilkan` yang mengembalikan cara menampilkan karya seni tersebut.

Dari kelas `KaryaSeni`, turunkan dua kelas yaitu `Lukisan` dan `Patung`. Kelas `Lukisan` ketika memanggil metode `deskripsi` akan mengembalikan "Sebuah gambar yang dilukis di atas kanvas", dan metode `tampilkan` mengembalikan "Digantung di dinding". Sedangkan kelas `Patung` ketika memanggil metode `deskripsi` akan mengembalikan "Sebuah objek tiga dimensi yang dibentuk", dan metode `tampilkan` mengembalikan "Diletakkan di atas meja atau lantai".

Buatlah sebuah kelas bernama `StudioSeni` yang memiliki informasi sebagai variabel instance berupa daftar karya seni (tipe List<KaryaSeni>). Kelas `StudioSeni` harus memiliki metode untuk menambahkan karya seni ke dalam daftar dengan nama `tambahKaryaSeni` dan metode `tampilkanSemuaKarya` yang mengembalikan daftar cara menampilkan semua karya seni yang ada di dalam daftar.

Buatlah sebuah kelas bernama `StudioSeniProgram` yang didalamnya terdapat metode static `main`. Instansiasi objek dari kelas `StudioSeni`, tambahkan beberapa karya seni ke dalam daftar, dan tampilkan cara menampilkan semua karya seni yang ada di daftar ke layar dengan memanggil metode `tampilkanSemuaKarya`.

**Catatan**: Fokus pada konsep polymorphism dimana kita dapat memanipulasi objek dari kelas turunan sebagai objek dari kelas induk.