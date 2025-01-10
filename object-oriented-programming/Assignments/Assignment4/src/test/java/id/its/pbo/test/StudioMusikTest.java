package id.its.pbo.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import id.its.pbo.music.*;

class StudioMusikTest {

    @Test
    @DisplayName("Dapat mengambil suara dari Gitar")
    public void testGitarSuara() {
        Gitar gitar = new Gitar("Gitar Akustik");
        assertEquals("tring tring", gitar.suara());
    }

    @Test
    @DisplayName("Dapat mengambil suara dari Piano")
    public void testPianoSuara() {
        Piano piano = new Piano("Piano Grand");
        assertEquals("tink tink", piano.suara());
    }

    @Test
    @DisplayName("Dapat menambahkan dan memainkan instrumen di StudioMusik")
    public void testTambahDanMainkanInstrumen() {
        StudioMusik studio = new StudioMusik();
        studio.tambahInstrumen(new Gitar("Gitar Akustik"));
        studio.tambahInstrumen(new Piano("Piano Grand"));
        assertEquals("tring tring tink tink", studio.mainkanInstrumen());
    }

    @Test
    @DisplayName("Dapat memastikan kelas StudioMusikProgram ada")
    public void testStudioMusikProgramExistence() {
        try {
            Class.forName("id.its.pbo.music.StudioMusikProgram");
            assertTrue(true); // Class ada
        } catch (ClassNotFoundException e) {
            assertTrue(false); // Class tidak ada
        }
    }

    @Test
    @DisplayName("Dapat memastikan method main ada di StudioMusikProgram")
    public void testMainMethodExistence() {
    	try {
            Class<?> clazz = Class.forName("id.its.pbo.music.StudioMusikProgram");
            clazz.getMethod("main", String[].class);
            assertTrue(true); // Method main() ada
        } catch (Exception e) {
            assertTrue(false); // Method main() tidak ada atau class tidak ditemukan
        }
    }
}
