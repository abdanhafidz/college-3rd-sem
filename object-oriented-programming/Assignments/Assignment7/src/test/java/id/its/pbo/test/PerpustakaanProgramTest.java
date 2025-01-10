package id.its.pbo.test;

import id.its.pbo.library.PerpustakaanProgram;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PerpustakaanProgramTest {
    @Test
    public void mainMethodExists() {
        // Mengecek apakah metode main ada di kelas PerpustakaanProgram
        try {
            PerpustakaanProgram.main(new String[]{});
        } catch (Exception e) {
            assertTrue(false, "Metode main harus ada dan tidak melempar exception");
        }
    }

    @Test
    public void mainMethodPrintsOutput() {
        // Menyiapkan stream untuk menangkap output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Menjalankan metode main
        PerpustakaanProgram.main(new String[]{});

        // Mengecek apakah output yang dicetak tidak kosong
        assertTrue(outContent.toString().length() > 0, "Metode main harus mencetak output");
    }
}
