package id.its.pbo.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import id.its.pbo.Date;

public class DateTest {

    @Test
    public void testConstructorAndFields() {
        Date date = new Date(12, 25, 2020);
        
        assertEquals(12, date.getMonth());
        assertEquals(25, date.getDay());
        assertEquals(2020, date.getYear());
    }
    
    @Test
    public void testDisplayDate() {
        Date date = new Date(12, 25, 2020);
        
        assertEquals("12/25/2020", date.displayDate());
    }

    @Test
    public void testInvalidDay() {
        Date date = new Date(2, 29, 2021);
        
        assertEquals(1, date.getDay());
    }
    
    @Test
    public void testInvalidNegativeDay() {
        Date date = new Date(2, -1, 2021);
        
        assertEquals(1, date.getDay());
    }
    
    @Test
    public void testInvalidMonth() {
        Date date = new Date(13, 29, 2021);
        
        assertEquals(1, date.getMonth());
    }
    
    @Test
    public void testInvalidNegativeMonth() {
        Date date = new Date(0, 29, 2021);
        
        assertEquals(1, date.getMonth());
    }
    
    @Test
    public void testNegativeYear() {
        Date date = new Date(2, 10, -1);
        
        assertEquals(0, date.getYear());
    }

    @Test
    public void testLeapYear() {
        Date date = new Date(2, 29, 2020);
        
        assertEquals(29, date.getDay());
    }
    
    @Test
    public void testDateProgramExistence() {
        try {
            Class.forName("id.its.pbo.DateProgram");
            assertTrue(true);
        } catch (ClassNotFoundException e) {
            assertTrue(false);
        }
    }

    @Test
    public void testMainMethodExistence() {
        try {
            Class<?> clazz = Class.forName("id.its.pbo.DateProgram");
            Method mainMethod = clazz.getMethod("main", String[].class);
            int modifiers = mainMethod.getModifiers();

            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                assertTrue(true);
            } else {
                assertTrue(false);
            }
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void testFieldsArePrivate() {
        Field[] fields = Date.class.getDeclaredFields();
        
        for (Field f : fields) {
            int modifiers = f.getModifiers();
            assertTrue(Modifier.isPrivate(modifiers), "Field " + f.getName() + " should be private");
        }
    }
}
