package id.its.pbo.test;

import id.its.pbo.library.Anggota;
import id.its.pbo.library.Buku;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BukuTest {
    @Test
    public void createBuku() {
        Buku buku = new Buku("Harry Potter", "J.K. Rowling", 1997);
        assertEquals("Harry Potter, J.K. Rowling, 1997", buku.getInfoBuku());
    }

    @Test
    public void addPeminjamToBuku() {
        Buku buku = new Buku("Harry Potter", "J.K. Rowling", 1997);
        Anggota anggota = new Anggota("Alice", "A001");
        buku.tambahPeminjam(anggota);
        assertEquals(1, buku.getDaftarPeminjam().size());
    }

    @Test
    public void getPeminjamInfo() {
        Buku buku = new Buku("Harry Potter", "J.K. Rowling", 1997);
        Anggota anggota = new Anggota("Alice", "A001");
        buku.tambahPeminjam(anggota);
        assertEquals("Alice, Alamat belum diisi, A001", buku.getDaftarPeminjam().get(0).getInfoAnggota());
    }
}
