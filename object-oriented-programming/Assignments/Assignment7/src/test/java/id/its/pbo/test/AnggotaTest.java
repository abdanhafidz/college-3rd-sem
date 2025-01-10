package id.its.pbo.test;

import id.its.pbo.library.Anggota;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnggotaTest {
    @Test
    public void createAnggotaWithTwoParameters() {
        Anggota anggota = new Anggota("Alice", "A001");
        assertEquals("Alice, Alamat belum diisi, A001", anggota.getInfoAnggota());
    }

    @Test
    public void createAnggotaWithThreeParameters() {
        Anggota anggota = new Anggota("Bob", "Jl. Merdeka No. 1", "B002");
        assertEquals("Bob, Jl. Merdeka No. 1, B002", anggota.getInfoAnggota());
    }
}
