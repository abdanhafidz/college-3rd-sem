package id.its.pbo.test;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.*;

import id.its.pbo.book.Buku;
import id.its.pbo.book.BukuFiksi;
import id.its.pbo.book.BukuPelajaran;

class BukuTest {
    
    @Test
    @DisplayName("Dapat mengambil nilai instance variable Buku menggunakan getter")
    public void testBukuGetter() {
        Buku buku = new Buku("Judul Buku", "Pengarang Buku");
        assertEquals("Judul Buku", buku.getJudul());
        assertEquals("Pengarang Buku", buku.getPengarang());
    }

    @Test
    @DisplayName("Dapat mengambil nilai instance variable BukuFiksi menggunakan getter")
    public void testBukuFiksiGetter() {
        BukuFiksi bukuFiksi = new BukuFiksi("Judul Fiksi", "Pengarang Fiksi", "Fantasi");
        assertEquals("Judul Fiksi", bukuFiksi.getJudul());
        assertEquals("Pengarang Fiksi", bukuFiksi.getPengarang());
        assertEquals("Fantasi", bukuFiksi.getGenre());
    }

    @Test
    @DisplayName("Dapat mengambil nilai instance variable BukuPelajaran menggunakan getter")
    public void testBukuPelajaranGetter() {
        BukuPelajaran bukuPelajaran = new BukuPelajaran("Judul Pelajaran", "Pengarang Pelajaran", "Matematika");
        assertEquals("Judul Pelajaran", bukuPelajaran.getJudul());
        assertEquals("Pengarang Pelajaran", bukuPelajaran.getPengarang());
        assertEquals("Matematika", bukuPelajaran.getSubjek());
    }
    
    @Test
    @DisplayName("Dapat memastikan attribute Buku diset private")
    public void testBukuFieldsArePrivate() {
        Field[] fields = Buku.class.getDeclaredFields();
        
        for (Field f : fields) {
            int modifiers = f.getModifiers();
            assertTrue(Modifier.isPrivate(modifiers), "Field " + f.getName() + " should be private");
        }
    }

    @Test
    @DisplayName("Dapat memastikan attribute BukuFiksi diset private")
    public void testBukuFiksiFieldsArePrivate() {
        Field[] fields = BukuFiksi.class.getDeclaredFields();
        
        for (Field f : fields) {
            int modifiers = f.getModifiers();
            assertTrue(Modifier.isPrivate(modifiers), "Field " + f.getName() + " should be private");
        }
    }

    @Test
    @DisplayName("Dapat memastikan attribute BukuPelajaran diset private")
    public void testBukuPelajaranFieldsArePrivate() {
        Field[] fields = BukuPelajaran.class.getDeclaredFields();
        
        for (Field f : fields) {
            int modifiers = f.getModifiers();
            assertTrue(Modifier.isPrivate(modifiers), "Field " + f.getName() + " should be private");
        }
    }
    
    @Test
    @DisplayName("Dapat memastikan BukuFiksi diturunkan dari Buku")
    public void testBukuFiksiInheritance() {
        assertTrue(BukuFiksi.class.getSuperclass().equals(Buku.class), "BukuFiksi should inherit from Buku");
    }

    @Test
    @DisplayName("Dapat memastikan BukuPelajaran diturunkan dari Buku")
    public void testBukuPelajaranInheritance() {
        assertTrue(BukuPelajaran.class.getSuperclass().equals(Buku.class), "BukuPelajaran should inherit from Buku");
    }

    @Test
    @DisplayName("Dapat memastikan BukuFiksi tidak mendeklarasikan ulang atribut dari Buku")
    public void testBukuFiksiFieldsRedeclaration() {
        Field[] fields = BukuFiksi.class.getDeclaredFields();
        
        for (Field f : fields) {
            assertFalse(f.getName().equals("judul") || f.getName().equals("pengarang"), "BukuFiksi should not redeclare inherited fields");
        }
    }

    @Test
    @DisplayName("Dapat memastikan BukuPelajaran tidak mendeklarasikan ulang atribut dari Buku")
    public void testBukuPelajaranFieldsRedeclaration() {
        Field[] fields = BukuPelajaran.class.getDeclaredFields();
        
        for (Field f : fields) {
            assertFalse(f.getName().equals("judul") || f.getName().equals("pengarang"), "BukuPelajaran should not redeclare inherited fields");
        }
    }
    
    @Test
    @DisplayName("Dapat memastikan kelas PerpustakaanProgram ada")
    public void testPerpustakaanProgramExistence() {
        try {
            Class.forName("id.its.pbo.book.PerpustakaanProgram");
            assertTrue(true); // Class ada
        } catch (ClassNotFoundException e) {
            assertTrue(false); // Class tidak ada
        }
    }

    @Test
    @DisplayName("Dapat memastikan method main ada di PerpustakaanProgram")
    public void testMainMethodExistence() {
    	try {
            Class<?> clazz = Class.forName("id.its.pbo.book.PerpustakaanProgram");
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
