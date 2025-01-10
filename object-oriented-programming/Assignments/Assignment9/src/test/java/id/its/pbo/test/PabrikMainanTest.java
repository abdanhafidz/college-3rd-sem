package id.its.pbo.test;

import id.its.pbo.toys.Mesin;
import id.its.pbo.toys.PabrikMainan;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PabrikMainanTest {
    @Test
    void testTotalProduksi() throws InterruptedException {
        Mesin mesin1 = new Mesin("Mesin 1", 100, 3);
        Mesin mesin2 = new Mesin("Mesin 2", 100, 2);
        
        PabrikMainan pabrik = new PabrikMainan();
        pabrik.tambahMesin(mesin1);
        pabrik.tambahMesin(mesin2);
        
        pabrik.mulaiProduksi();
        
        assertEquals(5, pabrik.getJumlahTotalProduksi());
    }
}
