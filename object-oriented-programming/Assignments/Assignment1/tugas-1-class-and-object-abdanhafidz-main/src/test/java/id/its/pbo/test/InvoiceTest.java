package id.its.pbo.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import id.its.pbo.Invoice;

class InvoiceTest {
	
	@Test
	@DisplayName("Dapat mengambil nilai instance variable menggunakan getter")
    public void testInvoiceGetter() {
        Invoice invoice = new Invoice("001", "Hammer", 2, 50.0);
        assertEquals("001", invoice.getPartNumber());
        assertEquals("Hammer", invoice.getPartDescription());
        assertEquals(2, invoice.getQuantity());
        assertEquals(50.0, invoice.getPrice());
    }
	
	@Test
	@DisplayName("Dapat set dan ambil nilai instance variable")
    public void testInvoiceSetterGetter() {
        Invoice invoice = new Invoice("", "", 0, 0.0);
        
        invoice.setPartNumber("002");
        invoice.setPartDescription("Nail");
        invoice.setQuantity(5);
        invoice.setPrice(100);
        
        assertEquals("002", invoice.getPartNumber());
        assertEquals("Nail", invoice.getPartDescription());
        assertEquals(5, invoice.getQuantity());
        assertEquals(100.0, invoice.getPrice());
    }

	@Test
	@DisplayName("Dapat menghitung nilai invoice")
    public void testInvoiceAmountCalculation() {
        Invoice invoice = new Invoice("001", "Hammer", 2, 50.0);
        assertEquals(100.0, invoice.getInvoiceAmount(), 0.0);
    }
	
	@Test
    @DisplayName("Dapat memastikan kuantitas getter tidak negatif")
    public void testNegativeQuantityGetter() {
        Invoice invoice = new Invoice("002", "Nail", -5, 10.0);
        invoice.setQuantity(-10);
        assertEquals(0, invoice.getQuantity(), 0.0);
    }

    @Test
    @DisplayName("Dapat memastikan kuantitas tidak negatif")
    public void testNegativeQuantity() {
        Invoice invoice = new Invoice("002", "Nail", -5, 10.0);
        assertEquals(0.0, invoice.getInvoiceAmount(), 0.0);
    }
    
    @Test
    @DisplayName("Dapat memastikan harga getter tidak negatif")
    public void testNegativePriceGetter() {
        Invoice invoice = new Invoice("003", "Screw", 5, -10.0);
        invoice.setPrice(-50.0);
        assertEquals(0.0, invoice.getPrice(), 0.0);
    }

    @Test
    @DisplayName("Dapat memastikan harga tidak negatif")
    public void testNegativePrice() {
        Invoice invoice = new Invoice("003", "Screw", 5, -10.0);
        assertEquals(0.0, invoice.getInvoiceAmount(), 0.0);
    }
    
    @Test
    @DisplayName("Dapat memastikan attribute diset private")
    public void testFieldsArePrivate() {
        Field[] fields = Invoice.class.getDeclaredFields();
        
        for (Field f : fields) {
            int modifiers = f.getModifiers();
            assertTrue(Modifier.isPrivate(modifiers), "Field " + f.getName() + " should be private");
        }
    }
    
    @Test
    @DisplayName("Dapat memastikan kelas InvoiceProgram ada")
    public void testInvoiceProgramExistence() {
        try {
            Class.forName("id.its.pbo.InvoiceProgram");
            assertTrue(true); // Class ada
        } catch (ClassNotFoundException e) {
            assertTrue(false); // Class tidak ada
        }
    }

    @Test
    @DisplayName("Dapat memastikan method main ada")
    public void testMainMethodExistence() {
    	try {
            Class<?> clazz = Class.forName("id.its.pbo.InvoiceProgram");
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
