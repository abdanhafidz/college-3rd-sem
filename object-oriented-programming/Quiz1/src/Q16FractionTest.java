public class Q16FractionTest {
    /**
    * This class is responsible for testing the functionality of the Q16Fraction class.
    * It contains methods to test various aspects of fraction operations, including 
    * conversion to string representation, multiplication, and addition.
    */

    public static void TestToString(Q16Fraction frac, String expected_result) {
        // Method to test the ToString() functionality of the Q16Fraction class.
        System.out.println("Testing with fraction test numerator = " + frac.getNumerator() + ", denominator = " + frac.getDenominator());
        // Output the current fraction's numerator and denominator.
        
        System.out.println("Expected Result = " + expected_result);
        // Output the expected string representation of the fraction.
        
        // Compare the actual string representation with the expected result.
        if (frac.ToString().equals(expected_result)) {
            System.out.println("Testing Passed!");
        } else {
            System.out.println("Testing Failed!");
        }
    }

    public static void TestgetProduct(Q16Fraction f1, Q16Fraction f2, String expected_result) {
        // Method to test the getProduct() functionality of the Q16Fraction class.
        System.out.println("Testing with fraction-1(f1) test numerator = " + f1.getNumerator() + ", denominator = " + f1.getDenominator());
        // Output the numerator and denominator of the first fraction.
        
        System.out.println("Testing with fraction-2(f2) test numerator = " + f2.getNumerator() + ", denominator = " + f2.getDenominator());
        // Output the numerator and denominator of the second fraction.
        
        System.out.println("Expected Result = " + expected_result);
        // Output the expected result of the product.
        
        // Calculate the product and convert it to string.
        String result = f2.getProduct(f1).ToString();
        System.out.println("Testing Result = " + result);
        // Output the actual result of the product.
        
        // Compare the actual product result with the expected result.
        if (result.equals(expected_result)) {
            System.out.println("Testing Passed!");
        } else {
            System.out.println("Testing Failed!");
        }
    }

    public static void TestgetSum(Q16Fraction f1, Q16Fraction f2, String expected_result) {
        // Method to test the getSum() functionality of the Q16Fraction class.
        System.out.println("Testing with fraction-1(f1) test numerator = " + f1.getNumerator() + ", denominator = " + f1.getDenominator());
        // Output the numerator and denominator of the first fraction.
        
        System.out.println("Testing with fraction-2(f2) test numerator = " + f2.getNumerator() + ", denominator = " + f2.getDenominator());
        // Output the numerator and denominator of the second fraction.
        
        System.out.println("Expected Result = " + expected_result);
        // Output the expected result of the sum.
        
        // Calculate the sum and convert it to string.
        String result = f2.getSum(f1).ToString();
        System.out.println("Testing Result = " + result);
        // Output the actual result of the sum.
        
        // Compare the actual sum result with the expected result.
        if (result.equals(expected_result)) {
            System.out.println("Testing Passed!");
        } else {
            System.out.println("Testing Failed!");
        }
    }

    public static void main(String[] args) {
        // Main method to execute the tests.
        try {
            // Test for f1 = 1/2 and f2 = 3/7
            Q16Fraction f1 = new Q16Fraction(1, 2);
            Q16Fraction f2 = new Q16Fraction(3, 7);
            
            System.out.println("\n === TESTING SCENARIO 1 : CONVERT FRACTION TO STRING == ");
            TestToString(f1, "1/2");
            
            System.out.println("\n === TESTING SCENARIO 2 : CONVERT FRACTION TO STRING == ");
            TestToString(f2, "3/7");
            
            System.out.println("\n === TESTING SCENARIO 3 : COUNT f1 * f2 == ");
            TestgetProduct(f1, f2, "3/14");
            
            System.out.println("\n === TESTING SCENARIO 4 : COUNT f1 + f2 == ");
            TestgetSum(f1, f2, "13/14");
        } catch (Exception e) {
            // Catch any unexpected exceptions that may occur during testing.
            System.out.println(e);
        }
    }
}
