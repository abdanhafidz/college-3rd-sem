public class Q15WeightTest {
    // Declaration of the Q15WeightTest class, which is designed to test the functionality of the Q15Weight class.
    
    private static void TestGetKilogram(double p, double expected_result) {
        // A static method that tests the getKilograms() method of the Q15Weight class.
        // It takes two parameters: 
        // 1. p - the weight in pounds to test.
        // 2. expected_result - the expected weight in kilograms for comparison.
        
        System.out.println("Testing with Given pounds = " + p);
        // Output the given weight in pounds for clarity.
        
        System.out.println("Result expected = " + expected_result);
        // Output the expected result to compare against the actual result.
        
        Q15Weight weight = new Q15Weight(p);
        // Create an instance of Q15Weight with the given pounds p.
        
        double result = weight.getKilograms();
        // Call the getKilograms() method to obtain the actual result in kilograms.
        
        System.out.println("Test Result = " + result);
        // Output the actual result obtained from the method.
        
        // Check if the actual result matches the expected result.
        if (result == expected_result) {
            System.out.println("Testing Passed!");
            // If the results match, print a success message.
        } else {
            System.out.println("Testing Failed!");
            // If the results do not match, print a failure message.
        }
    }

    public static void main(String[] args) {
        // Main method to execute the test.
        
        try {
            double expected_result = 0.45359237 * 1921221;
            // Calculate the expected result in kilograms for the given weight in pounds (1921221).
            
            TestGetKilogram(1921221, expected_result);
            // Call the TestGetKilogram method with the given weight in pounds and the expected result.
        } catch (Exception e) {
            // Catch any unexpected exceptions that may occur during the execution of the tests.
            System.out.println(e);
        }
    }
}
