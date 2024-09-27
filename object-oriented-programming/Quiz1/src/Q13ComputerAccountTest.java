// File: Q13ComputerAccountTest.java

public class Q13ComputerAccountTest {
    /**
    * This class is a test suite for the Q13ComputerAccount class.
    * It aims to validate the functionality of the changePassword method
    * through unit testing.
    */

    public static void main(String[] args) {
        // Main method to execute the unit tests for the Q13ComputerAccount class.
        
        try {
            // Creating an instance of Q13ComputerAccount with sample user data.
            Q13ComputerAccount Account = new Q13ComputerAccount("Abdan Hafidz", "abdanhafidz", "j03k03w1");
            
            // Test 1: Change Password with a valid previous password.
            // Here, we attempt to change the password from "j03k03w1" to "12345".
            Account.changePassword("j03k03w1", "12345");
            // This should successfully change the password and print a success message.
            
            // Test 2: Change Password with an invalid previous password.
            // We attempt to change the password using "12333" as the previous password,
            // which does not match the current password "12345".
            Account.changePassword("12333", "123456");
            // This should fail, printing an error message indicating the previous password is incorrect.
            
        } catch (Exception e) {
            // Catching any unexpected exceptions that may occur during the execution of the tests.
            // This ensures that the program does not crash and we can see any error messages.
            System.out.println(e);
        }
    }
}
