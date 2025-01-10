package id.its.pbo.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import id.its.pbo.art.*;

class StudioSeniTest {

    @Test
    @DisplayName("Dapat menambahkan dan menampilkan karya seni")
    public void testTambahDanTampilkanKaryaSeni() {
        StudioSeni studio = new StudioSeni();
        studio.tambahKaryaSeni(new Lukisan("Lukisan Alam"));
        studio.tambahKaryaSeni(new Patung("Patung Kuda"));

        assertEquals(2, studio.tampilkanSemuaKarya().size());
        assertEquals("Digantung di dinding", studio.tampilkanSemuaKarya().get(0));
        assertEquals("Diletakkan di atas meja atau lantai", studio.tampilkanSemuaKarya().get(1));
    }

    @Test
    @DisplayName("Dapat menampilkan deskripsi karya seni")
    public void testDeskripsiKaryaSeni() {
        Lukisan lukisan = new Lukisan("Lukisan Matahari Terbenam");
        Patung patung = new Patung("Patung Singa");

        assertEquals("Sebuah gambar yang dilukis di atas kanvas", lukisan.deskripsi());
        assertEquals("Sebuah objek tiga dimensi yang dibentuk", patung.deskripsi());
    }

    @Test
    @DisplayName("Dapat memastikan StudioSeniProgram memiliki metode main")
    public void testMainMethodExistence() {
        try {
            Class<?> clazz = Class.forName("id.its.pbo.art.StudioSeniProgram");
            clazz.getMethod("main", String[].class);
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

}
