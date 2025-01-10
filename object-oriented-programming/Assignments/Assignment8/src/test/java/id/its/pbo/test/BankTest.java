// BankTest.java
package id.its.pbo.test;

import id.its.pbo.bank.AkunBank;
import id.its.pbo.bank.Bank;
import id.its.pbo.bank.AkunTidakDitemukanException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    @Test
    public void cariAkunShouldReturnCorrectAkun() throws AkunTidakDitemukanException {
        Bank bank = new Bank();
        AkunBank akun = new AkunBank("12345", 5000);
        bank.tambahAkun(akun);
        assertEquals(akun, bank.cariAkun("12345"));
    }

    @Test
    public void cariAkunWithInvalidNomorShouldThrowException() {
        Bank bank = new Bank();
        assertThrows(AkunTidakDitemukanException.class, () -> bank.cariAkun("99999"));
    }
}
