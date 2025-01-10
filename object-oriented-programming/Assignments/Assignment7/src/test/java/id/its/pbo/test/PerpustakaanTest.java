package id.its.pbo.test;

import id.its.pbo.library.Anggota;
import id.its.pbo.library.Buku;
import id.its.pbo.library.Perpustakaan;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PerpustakaanTest {
    @Test
    public void addAnggotaToPerpustakaan() {
        Perpustakaan perpustakaan = new Perpustakaan();
        Anggota anggota = new Anggota("Alice", "A001");
        perpustakaan.tambahAnggota(anggota);
        assertEquals(1, perpustakaan.getDaftarAnggota().size());
    }

    @Test
    public void addBukuToPerpustakaan() {
        Perpustakaan perpustakaan = new Perpustakaan();
        Buku buku = new Buku("Harry Potter", "J.K. Rowling", 1997);
        perpustakaan.tambahBuku(buku);
        assertEquals(1, perpustakaan.getDaftarBuku().size());
    }
}
