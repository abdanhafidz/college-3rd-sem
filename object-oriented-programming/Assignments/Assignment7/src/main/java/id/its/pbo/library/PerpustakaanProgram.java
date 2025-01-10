package id.its.pbo.library;

public class PerpustakaanProgram {
    public static void main(String[] args) {
        Perpustakaan perpustakaanGwejh = new Perpustakaan();
        Buku bookHarryPotter = new Buku("Harry Potter", "J.K. Rowling", 1997);
        Buku bookTheHabit = new Buku("The Hobbit", "J.R.R. Tolkien", 1937);
        Anggota siAlice = new Anggota("Alice", "A001");
        Anggota siBob = new Anggota("Bob", "Jl. Merdeka No. 1", "B002");
        perpustakaanGwejh.tambahBuku(bookHarryPotter);
        perpustakaanGwejh.tambahBuku(bookTheHabit);
        perpustakaanGwejh.tambahAnggota(siBob);
        perpustakaanGwejh.tambahAnggota(siAlice);

        // Notes : Seharusnya kita tidak bisa menambahkan peminjam melalui method Buku secara langsung,
        // ide saya seharusnya tambahPeminjam hanya bisa diakses melalui class Perpustakaan
        // Solusi yang ideal adalah penerapan inner class, namun mengikuti test case sepertinya tidak valid

        System.out.println("Info Buku:");
        for(Buku r_Buku : perpustakaanGwejh.getDaftarBuku()){
            System.out.println("- "+r_Buku.getInfoBuku());
        }
        System.out.println("\n Info Anggota:");
        for(Anggota r_Anggota : perpustakaanGwejh.getDaftarAnggota()){
            System.out.println("- "+r_Anggota.getInfoAnggota());
        }
        for(Buku r_Buku : perpustakaanGwejh.getDaftarBuku()){
            System.out.println("Daftar Peminjam Buku "+'"'+r_Buku.getJudul()+'"'+":");
            for(Anggota r_Peminjam : r_Buku.getDaftarPeminjam()){
                System.out.println("- "+r_Peminjam.getInfoAnggota());
            }
        }
    }
}
