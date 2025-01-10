package id.its.pbo.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import id.its.pbo.perusahaan.Direktur;
import id.its.pbo.perusahaan.Karyawan;
import id.its.pbo.perusahaan.Manager;

public class DirekturTest {
    @Test
    public void createDirekturObject() {
        Direktur direktur = new Direktur("Alice", "D001", "Teknologi", 20000000.0);
        assertEquals("Alice", direktur.getNama());
        assertEquals("D001", direktur.getId());
        assertEquals("Teknologi", direktur.getDepartemen());
        assertEquals(20000000.0, direktur.getGaji());
    }

    @Test
    public void accessParentVariableFromDirektur() {
        Direktur direktur = new Direktur("Alice", "D001", "Teknologi", 20000000.0);
        // Casting to parent classes to access their variables
        Manager manager = (Manager) direktur;
        Karyawan karyawan = (Karyawan) direktur;
        assertEquals("Alice", manager.getNama());
        assertEquals("D001", manager.getId());
        assertEquals("Teknologi", manager.getDepartemen());
        assertEquals("Alice", karyawan.getNama());
        assertEquals("D001", karyawan.getId());
    }
}