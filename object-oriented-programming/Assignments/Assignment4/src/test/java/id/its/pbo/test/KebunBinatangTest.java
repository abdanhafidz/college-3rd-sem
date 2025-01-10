package id.its.pbo.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import id.its.pbo.zoo.*;

class KebunBinatangTest {

    @Test
    @DisplayName("Dapat mengambil nama dan suara Kucing")
    public void testKucingSuara() {
        Hewan kucing = new Kucing("Tom");
        assertEquals("Tom", kucing.getNama());
        assertEquals("Meong", kucing.buatSuara());
    }

    @Test
    @DisplayName("Dapat mengambil nama dan suara Anjing")
    public void testAnjingSuara() {
        Hewan anjing = new Anjing("Spike");
        assertEquals("Spike", anjing.getNama());
        assertEquals("Guk", anjing.buatSuara());
    }

    @Test
    @DisplayName("Dapat memastikan method main ada di KebunBinatangProgram")
    public void testMainMethodExistence() {
        try {
            Class<?> clazz = Class.forName("id.its.pbo.zoo.KebunBinatangProgram");
            clazz.getMethod("main", String[].class);
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }
    
    @Test
    @DisplayName("Dapat mengatur dan mengambil nama dari kelas Hewan (Kucing)")
    public void testKucingGetterSetter() {
        Hewan kucing = new Kucing("Tom");
        kucing.setNama("Jerry");
        assertEquals("Jerry", kucing.getNama());
    }

    @Test
    @DisplayName("Dapat mengatur dan mengambil nama dari kelas Hewan (Anjing)")
    public void testAnjingGetterSetter() {
        Hewan anjing = new Anjing("Spike");
        anjing.setNama("Tyke");
        assertEquals("Tyke", anjing.getNama());
    }
}
