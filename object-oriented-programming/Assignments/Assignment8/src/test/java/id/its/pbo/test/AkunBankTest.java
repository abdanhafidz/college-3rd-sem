// AkunBankTest.java
package id.its.pbo.test;

import org.junit.jupiter.api.Test;

import id.its.pbo.bank.AkunBank;
import id.its.pbo.bank.BatasPenarikanException;
import id.its.pbo.bank.SaldoTidakCukupException;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;

public class AkunBankTest {
    
    @Test
    public void testPenarikanMelebihiSaldo() {
        AkunBank akun = new AkunBank("1234567890", 4000.0);
        assertThrows(SaldoTidakCukupException.class, () -> {
            akun.tarik(5000.0);
        });
    }
    
    @Test
    public void testPenarikanMelebihiBatas() {
        AkunBank akun = new AkunBank("1234567890", 150000.0);
        assertThrows(BatasPenarikanException.class, () -> {
            akun.tarik(100001.0);
        });
    }

    @Test
    public void testPenarikanValid() {
        AkunBank akun = new AkunBank("1234567890", 6000.0);
        assertDoesNotThrow(() -> {
            akun.tarik(4000.0);
        });
        assertEquals(2000.0, akun.getSaldo());
    }
    
    @Test
    public void testKelasPengecekanAkunBankProgramAda() {
        try {
            Class<?> pengecekanAkunBankProgram = Class.forName("id.its.pbo.bank.PengecekanAkunBankProgram");
            assertNotNull(pengecekanAkunBankProgram);
        } catch (ClassNotFoundException e) {
            fail("Kelas PengecekanAkunBankProgram harus ada.");
        }
    }

    @Test
    public void testMetodeMainAda() {
        try {
            Class<?> pengecekanAkunBankProgram = Class.forName("id.its.pbo.bank.PengecekanAkunBankProgram");
            Method mainMethod = pengecekanAkunBankProgram.getDeclaredMethod("main", String[].class);
            assertNotNull(mainMethod);
        } catch (NoSuchMethodException e) {
            fail("Metode main harus ada di kelas PengecekanAkunBankProgram.");
        } catch (ClassNotFoundException e) {
            fail("Kelas PengecekanAkunBankProgram harus ada.");
        }
    }
}
