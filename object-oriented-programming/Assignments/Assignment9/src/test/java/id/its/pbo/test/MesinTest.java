package id.its.pbo.test;

import id.its.pbo.toys.Mesin;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MesinTest {
    @Test
    void testMesinProduksi() throws InterruptedException {
        Mesin mesin = new Mesin("Mesin Test", 100, 3);
        Thread threadMesin = new Thread(mesin);
        threadMesin.start();
        threadMesin.join();  // Ensure the test waits for the thread to finish
        
        assertEquals(3, mesin.getJumlahProduksi());
    }

    @Test
    void testMesinImplementsRunnable() {
        assertTrue(Runnable.class.isAssignableFrom(Mesin.class), "Mesin does not implement Runnable");
    }
}
