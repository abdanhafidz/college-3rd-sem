// PemeriksaanTest.java
package id.its.pbo.test;

import org.junit.jupiter.api.Test;

import id.its.pbo.medical.Pasien;
import id.its.pbo.medical.Pemeriksaan;

import static org.junit.jupiter.api.Assertions.*;

public class PemeriksaanTest {

    @Test
    public void testDataTidakLengkap() {
        Exception exception = assertThrows(Exception.class, () -> {
            Pasien pasien = new Pasien("", 20, "Jakarta");
            Pemeriksaan pemeriksaan = new Pemeriksaan();
            pemeriksaan.periksaData(pasien);
        });
        assertEquals("Pemeriksaan Gagal: Data pasien tidak lengkap.", exception.getMessage());
    }

    @Test
    public void testDataTidakValid() {
        Exception exception = assertThrows(Exception.class, () -> {
            Pasien pasien = new Pasien("John", 130, "Jakarta");
            Pemeriksaan pemeriksaan = new Pemeriksaan();
            pemeriksaan.periksaData(pasien);
        });
        assertEquals("Pemeriksaan Gagal: Data yang dimasukkan tidak valid.", exception.getMessage());
    }

    @Test
    public void testPemeriksaanProgramMemilikiMethodMain() {
        try {
            Class.forName("id.its.pbo.medical.PemeriksaanProgram").getDeclaredMethod("main", String[].class);
        } catch (NoSuchMethodException e) {
            fail("Method main tidak ditemukan di kelas PemeriksaanProgram.");
        } catch (ClassNotFoundException e) {
            fail("Kelas PemeriksaanProgram tidak ditemukan.");
        }
    }
}
