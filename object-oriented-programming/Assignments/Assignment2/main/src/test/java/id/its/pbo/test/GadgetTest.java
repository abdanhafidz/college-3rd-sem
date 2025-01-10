package id.its.pbo.test;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.*;

import id.its.pbo.gadget.Gadget;
import id.its.pbo.electronics.Smartphone;

class GadgetTest {
    
    @Test
    @DisplayName("Dapat memastikan Smartphone diturunkan dari Gadget")
    public void testSmartphoneInheritance() {
        assertTrue(Smartphone.class.getSuperclass().equals(Gadget.class), "Smartphone should inherit from Gadget");
    }

    @Test
    @DisplayName("Dapat mengambil informasi dari Smartphone")
    public void testSmartphoneInfo() {
        Smartphone smartphone = new Smartphone("Apple", 2021, "iOS");
        assertEquals("Brand: Apple, Tahun Rilis: 2021, Sistem Operasi: iOS", smartphone.infoSmartphone());
    }

    @Test
    @DisplayName("Dapat memastikan Gadget tidak memiliki public getter/setter untuk brand dan tahunRilis")
    public void testGadgetNoPublicGetterSetter() {
        Method[] methods = Gadget.class.getDeclaredMethods();
        for (Method m : methods) {
            assertFalse(m.getName().equals("getBrand") || m.getName().equals("setBrand") || m.getName().equals("getTahunRilis") || m.getName().equals("setTahunRilis"), "Gadget should not have public getter/setter for brand and tahunRilis");
        }
    }

    @Test
    @DisplayName("Dapat memastikan kelas GadgetProgram ada")
    public void testGadgetProgramExistence() {
        try {
            Class.forName("id.its.pbo.gadget.GadgetProgram");
            assertTrue(true); // Class ada
        } catch (ClassNotFoundException e) {
            assertTrue(false); // Class tidak ada
        }
    }

    @Test
    @DisplayName("Dapat memastikan method main ada di GadgetProgram")
    public void testMainMethodExistence() {
    	try {
            Class<?> clazz = Class.forName("id.its.pbo.gadget.GadgetProgram");
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
