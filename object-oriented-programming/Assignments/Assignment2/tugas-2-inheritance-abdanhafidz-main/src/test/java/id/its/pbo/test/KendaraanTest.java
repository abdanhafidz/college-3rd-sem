package id.its.pbo.test;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.*;

import id.its.pbo.vehicle.Kendaraan;
import id.its.pbo.transport.Mobil;

class KendaraanTest {
    
    @Test
    @DisplayName("Dapat mengambil nilai instance variable Mobil menggunakan getter dan memanfaatkan metode infoKendaraan")
    public void testMobilInfo() {
        Mobil mobil = new Mobil("Toyota", 2020, "SUV");
        assertEquals("SUV", mobil.getJenis());
        assertEquals("Merk: Toyota, Tahun: 2020, Jenis: SUV", mobil.infoMobil());
    }

    @Test
    @DisplayName("Dapat memastikan Mobil diturunkan dari Kendaraan")
    public void testMobilInheritance() {
        assertTrue(Mobil.class.getSuperclass().equals(Kendaraan.class), "Mobil should inherit from Kendaraan");
    }

    @Test
    @DisplayName("Dapat memastikan kelas KendaraanProgram ada")
    public void testKendaraanProgramExistence() {
        try {
            Class.forName("id.its.pbo.vehicle.KendaraanProgram");
            assertTrue(true); // Class ada
        } catch (ClassNotFoundException e) {
            assertTrue(false); // Class tidak ada
        }
    }

    @Test
    @DisplayName("Dapat memastikan method main ada di KendaraanProgram")
    public void testMainMethodExistence() {
    	try {
            Class<?> clazz = Class.forName("id.its.pbo.vehicle.KendaraanProgram");
            Method mainMethod = clazz.getMethod("main", String[].class);
            int modifiers = mainMethod.getModifiers();

            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                assertTrue(true); // Method main() ada dan sesuai
            } else {
                assertTrue(false); // Method main() ada tapi tidak sesuai
            }
        } catch (Exception e) {
            assertTrue(false); // Method main() tidak ada atau class tidak ditemukan
        }
    }
    
    @Test
    @DisplayName("Dapat memastikan kelas Kendaraan tidak mendeklarasikan public getter dan setter untuk merk dan tahunProduksi")
    public void testKendaraanPublicGettersSetters() {
        Method[] methods = Kendaraan.class.getDeclaredMethods();

        for (Method m : methods) {
            if (m.getName().equals("getMerk") || m.getName().equals("setMerk") || m.getName().equals("getTahunProduksi") || m.getName().equals("setTahunProduksi")) {
                int modifiers = m.getModifiers();
                assertFalse(Modifier.isPublic(modifiers), "Method " + m.getName() + " should not be public");
            }
        }
    }

}
