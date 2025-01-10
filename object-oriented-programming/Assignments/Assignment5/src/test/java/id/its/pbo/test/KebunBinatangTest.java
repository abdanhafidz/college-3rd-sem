// File: KebunBinatangTest.java
package id.its.pbo.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import id.its.pbo.zoo.*;

public class KebunBinatangTest {

    @Test
    public void testSingaBersuara() {
        Singa singa = new Singa("Leo");
        assertEquals("Roar", singa.suara());
    }

    @Test
    public void testKudaBersuara() {
        Kuda kuda = new Kuda("Pegasus");
        assertEquals("Neigh", kuda.suara());
    }

    @Test
    public void testUlarTidakBersuara() {
        Ular ular = new Ular("Python");
        assertFalse(ular instanceof BisaBersuara);
    }

    @Test
    public void testTambahHewan() {
        KebunBinatang kebun = new KebunBinatang();
        Singa singa = new Singa("Leo");
        kebun.tambahHewan(singa);
    }
    
    @Test
    @DisplayName("Memastikan KebunBinatangProgram memiliki method main")
    public void testMainMethodExistence() {
        try {
            Class<?> clazz = Class.forName("id.its.pbo.zoo.KebunBinatangProgram");
            clazz.getDeclaredMethod("main", String[].class);
            assertTrue(true); // Method main() ada
        } catch (NoSuchMethodException | ClassNotFoundException e) {
            assertTrue(false); // Method main() tidak ada atau class tidak ditemukan
        }
    }

    @Test
    @DisplayName("Memastikan Singa adalah turunan dari Hewan")
    public void testSingaInheritance() {
        assertTrue(Singa.class.getSuperclass().equals(Hewan.class), "Singa harus merupakan turunan dari Hewan");
    }

    @Test
    @DisplayName("Memastikan Kuda adalah turunan dari Hewan")
    public void testKudaInheritance() {
        assertTrue(Kuda.class.getSuperclass().equals(Hewan.class), "Kuda harus merupakan turunan dari Hewan");
    }

    @Test
    @DisplayName("Memastikan Ular adalah turunan dari Hewan")
    public void testUlarInheritance() {
        assertTrue(Ular.class.getSuperclass().equals(Hewan.class), "Ular harus merupakan turunan dari Hewan");
    }
}

