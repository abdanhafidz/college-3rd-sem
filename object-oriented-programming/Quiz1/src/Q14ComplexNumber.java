public class Q14ComplexNumber {
    private int real;       // The real part of the complex number
    private int imaginary;  // The imaginary part of the complex number

    // Constructor to initialize the real and imaginary parts of the complex number
    public Q14ComplexNumber(int real, int imaginary) {
        this.real = real;               // Assigns the real part
        this.imaginary = imaginary;     // Assigns the imaginary part
    }

    // Method to convert the complex number to a string representation
    public String ToString() {
        // If the imaginary part is positive or zero
        if (this.imaginary >= 0) {
            // Handle the case where imaginary part is 1 or -1
            if (this.imaginary == 1) {
                return this.real + "+i";  // Return as "a + i"
            } else if (this.imaginary == -1) {
                return this.real + "-i";  // Return as "a - i"
            } else {
                return this.real + "+" + this.imaginary + "i"; // Return as "a + bi"
            }
        } else {  // If the imaginary part is negative
            // Handle the case where imaginary part is 1 or -1
            if (this.imaginary == 1) {
                return this.real + "-i";  // Return as "a - i"
            } else if (this.imaginary == -1) {
                return this.real + "-i";   // Return as "a + i"
            } else {
                return this.real + "" + this.imaginary + "i"; // Return as "a + bi" (with negative b)
            }
        }
    }

    // Getter method for the real part
    public int getReal() {
        return this.real;  // Returns the real part
    }

    // Getter method for the imaginary part
    public int getImaginary() {
        return this.imaginary; // Returns the imaginary part
    }

    // Method to add two complex numbers
    public Q14ComplexNumber Addition(Q14ComplexNumber comp) {
        int real_count = comp.real + this.real;              // Sum the real parts
        int imaginary_count = comp.imaginary + this.imaginary; // Sum the imaginary parts
        Q14ComplexNumber result = new Q14ComplexNumber(real_count, imaginary_count); // Create the result complex number
        return result; // Return the result
    }

    // Method to subtract one complex number from another
    public Q14ComplexNumber Substraction(Q14ComplexNumber comp) {
        int real_count = this.real - comp.real;              // Subtract the real parts
        int imaginary_count = this.imaginary - comp.imaginary; // Subtract the imaginary parts
        Q14ComplexNumber result = new Q14ComplexNumber(real_count, imaginary_count); // Create the result complex number
        return result; // Return the result
    }

    // Method to multiply two complex numbers
    public Q14ComplexNumber Multiplication(Q14ComplexNumber comp) {
        int real_count = (comp.real * this.real) - (comp.imaginary * this.imaginary); // Calculate the real part of the product
        int imaginary_count = (comp.real * this.imaginary) + (comp.imaginary * this.real); // Calculate the imaginary part of the product
        Q14ComplexNumber result = new Q14ComplexNumber(real_count, imaginary_count); // Create the result complex number
        return result; // Return the result
    }
}
