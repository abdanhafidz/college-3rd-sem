public class Q13ComputerAccount {
    // Declaration of the Q13ComputerAccount class, which serves as the main class for creating computer account objects.
    
    private String realName;
    private String userName;
    private String password;
    // Declaration of three private attributes: realName, userName, and password.
    // These attributes are private, meaning they can only be accessed from within this class.

    public Q13ComputerAccount(String realName, String userName, String password) {
        // Constructor for the Q13ComputerAccount class.
        // This constructor initializes the attributes of the object with the provided parameters.
        this.realName = realName; // Assigning the parameter realName to the class attribute realName.
        this.userName = userName; // Assigning the parameter userName to the class attribute userName.
        this.password = password; // Assigning the parameter password to the class attribute password.
    }

    public void printRealName() {
        // Method to print the real name of the user.
        // This method outputs the realName attribute to the console.
        System.out.println("Your RealName is : " + this.realName);
    }

    public void printUserName() {
        // Method to print the user name of the account.
        // This method outputs the userName attribute to the console.
        System.out.println("Your UserName is : " + this.userName);
    }

    public void printPassword() {
        // Method to print the password of the account.
        // This method outputs the password attribute to the console.
        System.out.println("Your Password is : " + this.password);
    }

    public void changePassword(String prev_password, String NewPassword) {
        // Method to change the password of the account.
        // It takes two parameters: prev_password (the current password) and NewPassword (the new password).
        
        if (prev_password.equals(this.password)) {
            // Checks if the provided previous password matches the current password.
            this.password = NewPassword; // If it matches, updates the password attribute to the new password.
            
            if (this.password.equals(NewPassword)) {
                // Verifies if the password was successfully changed.
                System.out.println("Password Successfully Changed!"); // Outputs a success message.
            } else {
                System.out.println("Failed to Change Password!"); // Outputs a failure message if the password did not change.
            }
        } else {
            // If the previous password does not match, output an error message.
            System.out.println("Your Password is Wrong, invalid credential!");
        }
    }
}
