package id.its.pbo.test;

import id.its.pbo.transaction.Transaksi;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TransaksiTest {
    @Test
    public void testUniqueAndSequentialTransaksiID() {
    	Transaksi.resetCounter();
    	
        Transaksi t1 = new Transaksi(100.50);
        Transaksi t2 = new Transaksi(200.75);
        Transaksi t3 = new Transaksi(50.25);

        assertEquals(1, t1.getTransaksiID());
        assertEquals(2, t2.getTransaksiID());
        assertEquals(3, t3.getTransaksiID());
    }

    @Test
    public void testTotalTransaksi() {
    	Transaksi.resetCounter();
    	
        int initialCount = Transaksi.getTotalTransaksi();

        new Transaksi(100.50);
        new Transaksi(200.75);
        new Transaksi(50.25);

        assertEquals(initialCount + 3, Transaksi.getTotalTransaksi());
    }
    
    @Test
    public void testResetCounter() {
        new Transaksi(100.50);
        new Transaksi(200.75);
        Transaksi.resetCounter();
        assertEquals(0, Transaksi.getTotalTransaksi());

        Transaksi t1 = new Transaksi(50.25);
        assertEquals(1, t1.getTransaksiID());
    }
}

