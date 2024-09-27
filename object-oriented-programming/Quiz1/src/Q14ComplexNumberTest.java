public class Q14ComplexNumberTest {
    
    // Method to test the ToString() method of Q14ComplexNumber
    public static void TestToString(Q14ComplexNumber comp_number, String expected_value) {
        System.out.println("Given Test Complex Number, Real part = " + comp_number.getReal() + ", Imaginary Part = " + comp_number.getImaginary());
        System.out.println("Expected result test = " + expected_value);
        
        // Call the ToString() method to get the string representation of the complex number
        String result = comp_number.ToString();
        System.out.println("Result = " + result);
        
        // Check if the result matches the expected value
        if (result.equals(expected_value)) {
            System.out.println("Testing Passed!");
        } else {
            System.out.println("Testing Failed!");
        }
    }

    // Method to test the Addition() method of Q14ComplexNumber
    public static void TestAddition(Q14ComplexNumber comp_number, Q14ComplexNumber comp_number2, String expected_value) {
        System.out.println("Given Test Complex Number, Real part = " + comp_number.getReal() + ", Imaginary Part = " + comp_number.getImaginary());
        System.out.println("Expected result test = " + expected_value);
        
        // Perform addition and get the string representation of the result
        String result = comp_number.Addition(comp_number2).ToString();
        System.out.println("Result = " + result);
        
        // Check if the result matches the expected value
        if (result.equals(expected_value)) {
            System.out.println("Testing Passed!");
        } else {
            System.out.println("Testing Failed!");
        }
    }

    // Method to test the Substraction() method of Q14ComplexNumber
    public static void TestSubstraction(Q14ComplexNumber comp_number, Q14ComplexNumber comp_number2, String expected_value) {
        System.out.println("Given Test Complex Number, Real part = " + comp_number.getReal() + ", Imaginary Part = " + comp_number.getImaginary());
        System.out.println("Expected result test = " + expected_value);
        
        // Perform subtraction and get the string representation of the result
        String result = comp_number.Substraction(comp_number2).ToString();
        System.out.println("Result = " + result);
        
        // Check if the result matches the expected value
        if (result.equals(expected_value)) {
            System.out.println("Testing Passed!");
        } else {
            System.out.println("Testing Failed!");
        }
    }

    // Method to test the Multiplication() method of Q14ComplexNumber
    public static void TestMultiplication(Q14ComplexNumber comp_number, Q14ComplexNumber comp_number2, String expected_value) {
        System.out.println("Given Test Complex Number, Real part = " + comp_number.getReal() + ", Imaginary Part = " + comp_number.getImaginary());
        System.out.println("Expected result test = " + expected_value);
        
        // Perform multiplication and get the string representation of the result
        String result = comp_number.Multiplication(comp_number2).ToString();
        System.out.println("Result = " + result);
        
        // Check if the result matches the expected value
        if (result.equals(expected_value)) {
            System.out.println("Testing Passed!");
        } else {
            System.out.println("Testing Failed!");
        }
    }

    // Main method to run all the tests
    public static void main(String[] args) {
        Q14ComplexNumber comp_number1 = new Q14ComplexNumber(3, 2); // Create a complex number 3 + 2i
        Q14ComplexNumber comp_number2 = new Q14ComplexNumber(2, -1); // Create a complex number 2 - 1i
        
        // Testing scenarios
        System.out.println("\n=== TESTING SCENARIO 1 : Get String Complex Number ===");
        TestToString(comp_number1, "3+2i"); // Test the string representation of the first complex number
        System.out.println("\n");
        TestToString(comp_number2, "2-i");   // Test the string representation of the second complex number
        
        System.out.println("\n=== TESTING SCENARIO 2 : Get Addition ===");
        TestAddition(comp_number1, comp_number2, "5+i"); // Test the addition of the two complex numbers
        
        System.out.println("\n=== TESTING SCENARIO 3 : Get Substraction ===");
        TestSubstraction(comp_number1, comp_number2, "1+3i"); // Test the subtraction of the two complex numbers
        
        System.out.println("\n=== TESTING SCENARIO 4 : Get Multiplication ===");
        TestMultiplication(comp_number1, comp_number2, "8+i"); // Test the multiplication of the two complex numbers
    }
}
