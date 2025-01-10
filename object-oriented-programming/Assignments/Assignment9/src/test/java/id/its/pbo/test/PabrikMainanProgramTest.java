package id.its.pbo.test;

import id.its.pbo.toys.PabrikMainanProgram;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class PabrikMainanProgramTest {
    @Test
    void testMainMethodExists() {
        try {
            PabrikMainanProgram.class.getDeclaredMethod("main", String[].class);
        } catch (NoSuchMethodException e) {
            fail("Method main does not exist in PabrikMainanProgram");
        }
    }

    @Test
    void testConsoleOutput() {
        // Redirecting console output to a ByteArrayOutputStream
        ByteArrayOutputStream content = new ByteArrayOutputStream();
        System.setOut(new PrintStream(content));

        // Calling the main method to produce output
        PabrikMainanProgram.main(new String[]{});

        // Checking if the output contains the expected string
        String output = content.toString();
        assertTrue(output.contains("Total mainan yang diproduksi:"), "Console output does not contain expected text");
    }
}
