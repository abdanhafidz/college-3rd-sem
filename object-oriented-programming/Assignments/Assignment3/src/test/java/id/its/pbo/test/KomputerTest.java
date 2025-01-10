package id.its.pbo.test;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.*;

import id.its.pbo.computer.Komputer;
import id.its.pbo.computer.Processor;
import id.its.pbo.computer.Memory;

class KomputerTest {
    
    @Test
    @DisplayName("Dapat mengambil informasi dari Komputer")
    public void testKomputerInfo() {
        Processor processor = new Processor("AMD", 4.0);
        Memory memory = new Memory(32, "DDR5");
        Komputer komputer = new Komputer(processor, memory);
        assertEquals("Processor Brand: AMD, Kecepatan: 4.0 GHz, Memory Kapasitas: 32 GB, Tipe: DDR5", komputer.infoKomputer());
    }

    @Test
    @DisplayName("Dapat memastikan kelas KomputerProgram ada")
    public void testKomputerProgramExistence() {
        try {
            Class.forName("id.its.pbo.computer.KomputerProgram");
            assertTrue(true); // Class ada
        } catch (ClassNotFoundException e) {
            assertTrue(false); // Class tidak ada
        }
    }

    @Test
    @DisplayName("Dapat memastikan method main ada di KomputerProgram")
    public void testMainMethodExistence() {
    	try {
            Class<?> clazz = Class.forName("id.its.pbo.computer.KomputerProgram");
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
    @DisplayName("Dapat memastikan setter dan getter untuk variabel instance di kelas Processor dideklarasikan")
    public void testProcessorSettersGetters() {
        try {
            Processor processor = new Processor("Intel", 3.5);

            // Test getter
            assertEquals("Intel", processor.getBrand());
            assertEquals(3.5, processor.getKecepatan());

            // Test setter
            processor.setBrand("AMD");
            processor.setKecepatan(4.0);
            assertEquals("AMD", processor.getBrand());
            assertEquals(4.0, processor.getKecepatan());

        } catch (Exception e) {
            fail("Setter atau Getter di kelas Processor tidak ditemukan atau tidak berfungsi dengan benar.");
        }
    }

    @Test
    @DisplayName("Dapat memastikan setter dan getter untuk variabel instance di kelas Memory dideklarasikan")
    public void testMemorySettersGetters() {
        try {
            Memory memory = new Memory(16, "DDR4");

            // Test getter
            assertEquals(16, memory.getKapasitas());
            assertEquals("DDR4", memory.getTipeMemory());

            // Test setter
            memory.setKapasitas(32);
            memory.setTipeMemory("DDR5");
            assertEquals(32, memory.getKapasitas());
            assertEquals("DDR5", memory.getTipeMemory());

        } catch (Exception e) {
            fail("Setter atau Getter di kelas Memory tidak ditemukan atau tidak berfungsi dengan benar.");
        }
    }

    @Test
    @DisplayName("Dapat memastikan setter dan getter untuk variabel instance di kelas Komputer dideklarasikan")
    public void testKomputerSettersGetters() {
        try {
            Processor processor = new Processor("Intel", 3.5);
            Memory memory = new Memory(16, "DDR4");
            Komputer komputer = new Komputer(processor, memory);

            // Test getter
            assertEquals(processor, komputer.getProcessor());
            assertEquals(memory, komputer.getMemory());

            // Test setter
            Processor newProcessor = new Processor("AMD", 4.0);
            Memory newMemory = new Memory(32, "DDR5");
            komputer.setProcessor(newProcessor);
            komputer.setMemory(newMemory);
            assertEquals(newProcessor, komputer.getProcessor());
            assertEquals(newMemory, komputer.getMemory());

        } catch (Exception e) {
            fail("Setter atau Getter di kelas Komputer tidak ditemukan atau tidak berfungsi dengan benar.");
        }
    }

}
