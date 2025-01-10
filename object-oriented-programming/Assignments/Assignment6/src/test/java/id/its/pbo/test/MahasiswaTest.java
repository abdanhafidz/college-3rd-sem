package id.its.pbo.test;

import org.junit.jupiter.api.Test;

import id.its.pbo.registration.Mahasiswa;
import id.its.pbo.registration.PendaftaranProgram;

import static org.junit.jupiter.api.Assertions.*;

public class MahasiswaTest {
    @Test
    public void testNomorPendaftaran() {
        Mahasiswa m1 = new Mahasiswa("Ali");
        assertEquals(1, m1.getNomorPendaftaran());

        Mahasiswa m2 = new Mahasiswa("Budi");
        assertEquals(2, m2.getNomorPendaftaran());
    }

    @Test
    public void testTotalRegistrant() {
        Mahasiswa.resetRegistrantCounter();
        Mahasiswa m1 = new Mahasiswa("Ali");
        Mahasiswa m2 = new Mahasiswa("Budi");
        assertEquals(2, Mahasiswa.getTotalRegistrant());
    }

    @Test
    public void testResetRegistrantCounter() {
        Mahasiswa m1 = new Mahasiswa("Ali");
        Mahasiswa m2 = new Mahasiswa("Budi");
        Mahasiswa.resetRegistrantCounter();
        assertEquals(0, Mahasiswa.getTotalRegistrant());
    }

    @Test
    public void testPendaftaranProgramMainMethodExists() {
        try {
            PendaftaranProgram.class.getDeclaredMethod("main", String[].class);
        } catch (NoSuchMethodException e) {
            fail("Method main tidak ditemukan");
        }
    }
}

