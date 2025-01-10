public class Q15Weight {
    // Declaration of the Q15Weight class, which is designed to represent weight in pounds and convert it to kilograms.
    
    private double p;
    // Declaration of a private attribute 'p' that stores the weight in pounds.
    // The 'private' access modifier ensures that this attribute can only be accessed within this class.

    public Q15Weight(double p) {
        // Constructor for the Q15Weight class.
        // This constructor initializes the 'p' attribute with the provided parameter.
        this.p = p; // Assigning the value of the parameter 'p' to the class attribute 'p'.
    }

    public double getPound() {
        // Method to retrieve the weight in pounds.
        // This method returns the value of the 'p' attribute, representing the weight in pounds.
        return this.p; 
    }

    public double getKilograms() {
        // Method to convert and retrieve the weight in kilograms.
        // This method uses the conversion factor (1 pound = 0.45359237 kilograms) to calculate the equivalent weight in kilograms.
        return this.p * 0.45359237; 
    }
}
