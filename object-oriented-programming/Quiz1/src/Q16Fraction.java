public class Q16Fraction {
    // Declaration of the Q16Fraction class, which represents a mathematical fraction with a numerator and denominator.

    private int numerator;
    private int denominator;
    // Private attributes to store the numerator and denominator of the fraction.
    // The 'private' access modifier ensures these attributes can only be accessed within this class.

    public Q16Fraction(int numerator, int denominator) {
        // Constructor for the Q16Fraction class.
        // This constructor initializes the fraction with the specified numerator and denominator.
        this.numerator = numerator; // Assigning the provided numerator to the class attribute.
        this.denominator = denominator; // Assigning the provided denominator to the class attribute.
    }

    /** 
    * This method calculates the greatest common divisor (gcd) of two integers.
    * The gcd is used to simplify fractions later on.
    * It is declared as private because it is only used within this class.
    */
    private static int gcd(int a, int b) {
        int i;
        // Determine the smaller of the two numbers to limit the loop for efficiency.
        if (a < b)
            i = a;
        else
            i = b;

        // Loop from the smaller number down to 2 to find the gcd.
        for (i = i; i > 1; i--) {
            // Check if both numbers are divisible by 'i'.
            if (a % i == 0 && b % i == 0)
                return i; // Return the greatest common divisor.
        }
        return 1; // If no common divisor greater than 1 is found, return 1 (the gcd of any two numbers).
    }

    public String ToString() {
        // Method to return the string representation of the fraction in simplified form.
        int gcd = gcd(this.numerator, this.denominator); // Calculate the gcd of the numerator and denominator.
        int simplynum = this.numerator / gcd; // Simplify the numerator by dividing by the gcd.
        int simplyDenom = this.denominator / gcd; // Simplify the denominator by dividing by the gcd.
        return simplynum + "/" + simplyDenom; // Return the simplified fraction as a string.
    }

    public int getNumerator() {
        // Getter method to retrieve the numerator of the fraction.
        return this.numerator; // Returns the value of the numerator.
    }

    public int getDenominator() {
        // Getter method to retrieve the denominator of the fraction.
        return this.denominator; // Returns the value of the denominator.
    }

    public Q16Fraction getProduct(Q16Fraction frac) {
        // Method to calculate the product of this fraction with another fraction (frac).
        // The product of two fractions is given by multiplying their numerators and denominators.
        Q16Fraction ProductResult = new Q16Fraction(this.numerator * frac.getNumerator(), this.denominator * frac.getDenominator());
        // Create a new Q16Fraction representing the product.
        return ProductResult; // Return the resulting fraction.
    }

    public Q16Fraction getSum(Q16Fraction frac) {
        // Method to calculate the sum of this fraction with another fraction (frac).
        // The sum of two fractions is given by cross-multiplying and adding the numerators while multiplying the denominators.
        Q16Fraction SumResult = new Q16Fraction(
            (this.numerator * frac.getDenominator() + frac.numerator * this.denominator),
            this.denominator * frac.getDenominator()
        );
        // Create a new Q16Fraction representing the sum.
        return SumResult; // Return the resulting fraction.
    }
}
