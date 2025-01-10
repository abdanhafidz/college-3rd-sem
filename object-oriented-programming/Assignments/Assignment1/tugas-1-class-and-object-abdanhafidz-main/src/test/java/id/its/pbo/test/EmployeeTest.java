package id.its.pbo.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import id.its.pbo.Employee;

public class EmployeeTest {

    @Test
    public void testConstructorAndFields() {
        Employee employee = new Employee("Test", "User", 1000);
        
        assertEquals("Test", employee.getFirstName());
        assertEquals("User", employee.getLastName());
        assertEquals(1000, employee.getMonthlySalary());
    }

    @Test
    public void testRaiseSalary() {
        Employee employee = new Employee("Test", "User", 1000);
        employee.raiseSalary(10);
        
        assertEquals(1100, employee.getMonthlySalary());
    }

    @Test
    public void testRaiseSalaryCannotBeNegative() {
        Employee employee = new Employee("Test", "User", 1000);
        employee.raiseSalary(-10);
        
        assertEquals(1000, employee.getMonthlySalary());
    }

    
    @Test
    public void testSetMonthlySalary() {
        Employee employee = new Employee("Test", "User", 1000);
        employee.setMonthlySalary(-2000);  // Shouldn't change the value because the salary is negative
        
        assertEquals(1000, employee.getMonthlySalary());
        
        employee.setMonthlySalary(2000);  // Should change the value because the salary is positive
        
        assertEquals(2000, employee.getMonthlySalary());
    }

    @Test
    public void testYearlySalary() {
        Employee employee = new Employee("Test", "User", 1000);
        
        assertEquals(12000, employee.getYearlySalary());
    }
    
    @Test
    public void testEmployeeProgramExistence() {
        try {
            Class.forName("id.its.pbo.EmployeeProgram");
            assertTrue(true); // Class ada
        } catch (ClassNotFoundException e) {
            assertTrue(false); // Class tidak ada
        }
    }

    @Test
    public void testMainMethodExistence() {
    	try {
            Class<?> clazz = Class.forName("id.its.pbo.EmployeeProgram");
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
    public void testSetFirstNameMethodNotExist() {
    	try {
            Class<?> clazz = Class.forName("id.its.pbo.Employee");
            Method mainMethod = clazz.getMethod("setFirstName", String.class);
            int modifiers = mainMethod.getModifiers();

            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                assertTrue(false); // Method setFirstName() ada dan sesuai
            } else {
                assertTrue(true); // Method setFirstName() ada tapi tidak sesuai
            }
        } catch (Exception e) {
            assertTrue(true); // Method setFirstName() tidak ada atau class tidak ditemukan
        }
    }
    
    @Test
    public void testSetLastNameMethodNotExist() {
    	try {
            Class<?> clazz = Class.forName("id.its.pbo.Employee");
            Method mainMethod = clazz.getMethod("setLastName", String.class);
            int modifiers = mainMethod.getModifiers();

            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                assertTrue(false); // Method setLastName() ada dan sesuai
            } else {
                assertTrue(true); // Method setLastName() ada tapi tidak sesuai
            }
        } catch (Exception e) {
            assertTrue(true); // Method setLastName() tidak ada atau class tidak ditemukan
        }
    }
    
    @Test
    public void testFieldsArePrivate() {
        Field[] fields = Employee.class.getDeclaredFields();
        
        for (Field f : fields) {
            int modifiers = f.getModifiers();
            assertTrue(Modifier.isPrivate(modifiers), "Field " + f.getName() + " should be private");
        }
    }
}