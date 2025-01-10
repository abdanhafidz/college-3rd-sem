package id.its.pbo.test;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.*;

import id.its.pbo.store.Buku;
import id.its.pbo.store.TokoBuku;

class TokoBukuTest {

    @Test
    @DisplayName("Dapat menambahkan buku ke dalam daftar")
    public void testTambahBuku() {
        TokoBuku toko = new TokoBuku();
        Buku buku = new Buku("1234567890", "Harry Potter", 150000);
        toko.tambahBuku(buku);

        assertTrue(toko.getDaftarBuku().contains(buku));
    }

    @Test
    @DisplayName("Dapat menghapus buku dari daftar")
    public void testHapusBuku() {
        TokoBuku toko = new TokoBuku();
        Buku buku = new Buku("1234567890", "Harry Potter", 150000);
        toko.tambahBuku(buku);
        toko.hapusBuku(buku);

        assertFalse(toko.getDaftarBuku().contains(buku));
    }

    @Test
    @DisplayName("Dapat mencari buku berdasarkan ISBN")
    public void testCariBuku() {
        TokoBuku toko = new TokoBuku();
        Buku buku = new Buku("1234567890", "Harry Potter", 150000);
        toko.tambahBuku(buku);

        Buku bukuHasil = toko.cariBuku("1234567890");
        assertNotNull(bukuHasil);
        assertEquals("Harry Potter", bukuHasil.getJudul());
    }

    @Test
    @DisplayName("Dapat memastikan setter dan getter untuk variabel instance di kelas Buku dideklarasikan")
    public void testBukuSettersGetters() {
        Buku buku = new Buku("1234567890", "Harry Potter", 150000);

        assertEquals("1234567890", buku.getIsbn());
        assertEquals("Harry Potter", buku.getJudul());
        assertEquals(150000, buku.getHarga());

        buku.setIsbn("0987654321");
        buku.setJudul("Lord of the Rings");
        buku.setHarga(200000);

        assertEquals("0987654321", buku.getIsbn());
        assertEquals("Lord of the Rings", buku.getJudul());
        assertEquals(200000, buku.getHarga());
    }
    
    @Test
    @DisplayName("Dapat memastikan method main ada di TokoBukuProgram")
    public void testMainMethodExistence() {
    	try {
            Class<?> clazz = Class.forName("id.its.pbo.store.TokoBukuProgram");
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
}
