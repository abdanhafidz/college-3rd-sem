public class Q11Fraction{
    // First, we define the required variables according to those given in the question
    private int e1, e2, d1, d2;

    // Then create a constructor where we can fill in the class parameters inside
    public Q11Fraction(int e1, int e2, int d1, int d2){
        // Enter the parameter values ​​into private class variables
        this.e1 = e1;
        this.e2 = e2;
        this.d1 = d1;
        this.d2 = d2;
    }
    /** 
    Later we will display fractions in simple form. 
    In accordance with the concept of Mathematics, 
    we can divide the denominator and numerator respectively by the greatest common divisor (gcd).
    So we need to declare this function in the class.
    */ 
    private static int gcd(int a, int b)
    {
        int i;
        if (a < b)
            i = a;
        else
            i = b;
        for (i = i; i > 1; i--) {
            if (a % i == 0 && b % i == 0)
                return i;
        }
        return 1;
    }
    // Function get the result of fractions summation
    public String CountSum(){
        int counter = this.e1 * this.d2 + this.e2 * this.d1; // count the counter
        int denom = this.d1 * this.d2; // count the denominater
        int gcd = gcd(counter,denom);
        counter /= gcd; // Simplify the fraction divide it with gcd
        denom /= gcd; // Simplify the fraction divide it with gcd
        String ret = counter + "/" + denom; // we want to return it as a formatted string a/b
        return ret;
    }
    // Function get the result of fractions multiplication / product
    public String CountProduct(){
        int counter = this.e1 * this.e2; // count the counter
        int denom = this.d1 * this.d2; // count the denominater
        int gcd = gcd(counter,denom);
        counter /= gcd; // Simplify the fraction divide it with gcd
        denom /= gcd; // Simplify the fraction divide it with gcd
        String ret = counter + "/" + denom; // we want to return it as a formatted string a/b
        return ret;
    }
    // I will make a unit test to see whether 
    
    private void TestSum(String expected_result){
        System.out.println("Testing with Given = " + this.e1 + "/" + this.d1 + "+" + this.e2 + "/" + this.d2);
        System.out.println("Result expected = " + expected_result );
        String result = this.CountSum();
         System.out.println("Test Result = " + result );
        // if we give a value to the test function, the expected results will match the results of the function's work
        if(result.equals(expected_result)){
            System.out.println("Testing Passed!");
        }else{
            System.out.println("Testing Failed!");
        }
    }
    private void TestProduct(String expected_result){
        System.out.println("Testing with Given = " + this.e1 + "/" + this.d1 + "*" + this.e2 + "/" + this.d2);
        System.out.println("Result expected = " + expected_result );
        String result = this.CountProduct();
         System.out.println("Test Result = " + result );
        // if we give a value to the test function, the expected results will match the results of the function's work
        if(result.equals(expected_result)){
            System.out.println("Testing Passed!");
        }else{
            System.out.println("Testing Failed!");
        }
    }
    public static void main(String[] args) {
        try {
            // From the question, a case example is given for 

            // 1.calculating 1/2 + 1/3 
            System.out.println("\n === SCENARIO TESTING 1 ===");
            Q11Fraction Frac1 = new Q11Fraction(1,1,2,3);
            // where this is expected to produce 5/6
            Frac1.TestSum("5/6");

            // 2.calculating 1/3 + 3/4 
            System.out.println("\n === SCENARIO TESTING 2 ===");
            Q11Fraction Frac2 = new Q11Fraction(1,3,3,4);
            // where this is expected to produce 13/12
            Frac2.TestSum("13/12");

            // 3.calculating 1/2 * 2/3 
            System.out.println("\n === SCENARIO TESTING 3 ===");
            Q11Fraction Frac3 = new Q11Fraction(1,2,2,3);
            // where this is expected to produce 13/12
            Frac3.TestProduct("1/3");

            // 4.calculating 1/4 * 2/3 
            System.out.println("\n === SCENARIO TESTING 3 ===");
            Q11Fraction Frac4 = new Q11Fraction(1,2,4,3);
            // where this is expected to produce 13/12
            Frac4.TestProduct("1/6");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
