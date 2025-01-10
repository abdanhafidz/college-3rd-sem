package id.its.pbo.test;

import id.its.pbo.perusahaan.Manager;
import id.its.pbo.perusahaan.Karyawan;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {
    @Test
    public void createManagerObject() {
        Manager manager = new Manager("Charlie", "M001", "Keuangan");
        assertEquals("Charlie", manager.getNama());
        assertEquals("M001", manager.getId());
        assertEquals("Keuangan", manager.getDepartemen());
    }

    @Test
    public void accessParentVariableFromManager() {
        Manager manager = new Manager("Charlie", "M001", "Keuangan");
        // Casting to parent class to access its variables
        Karyawan karyawan = (Karyawan) manager;
        assertEquals("Charlie", karyawan.getNama());
        assertEquals("M001", karyawan.getId());
    }
}
