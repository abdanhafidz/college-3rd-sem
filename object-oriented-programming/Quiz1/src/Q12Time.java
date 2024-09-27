public class Q12Time {
    // Private instance variables to store hours and minutes
    private int hours;
    private int minutes;

    // Constructor that takes time in "HH:MM" format and splits it into hours and minutes
    public Q12Time(String time){
        String [] time_r = time.split(":"); // Splits the string into hours and minutes
        this.hours = Integer.valueOf(time_r[0]); // Parses hours from the string
        this.minutes = Integer.valueOf(time_r[1]); // Parses minutes from the string
    }

    // Private static method to calculate the absolute difference between two numbers
    private static int abs(int x, int y){
        if(x > y){
            return x - y; // Returns x - y if x is greater than y
        }else{
            return y - x; // Returns y - x otherwise
        }
    }

    // Public method to calculate the angle between the hour and minute hands
    public String CountAngle(){
        if(this.hours > 12 ){
            this.hours %= 12; // Converts hours to a 12-hour format if it exceeds 12
        }
        /** The formula for calculating the angle between the hour and minute hands:
        1. The hour hand moves 30 degrees for every hour (360 degrees / 12 hours).
           Additionally, it moves 0.5 degrees for every minute (30 degrees / 60 minutes).
        2. The minute hand moves 6 degrees for every minute (360 degrees / 60 minutes).
        3. To calculate the difference between the hour and minute hand angles,
            we subtract the smaller angle from the larger one, and then subtract this value from 360
            to get the correct angle between the two hands, ensuring the result is always positive.
         Formula to calculate the minute hand`s contribution to the hour angle */

        int MinsFloor = (int) (0.5 * this.minutes);
        // Calculate the angle of the hour hand from 12:00 (0 degrees)
        int AngleHours = (this.hours * 30 + MinsFloor);
        // Calculate the angle of the minute hand from 12:00 (0 degrees)
        int AngleMinutes = (this.minutes * 6);
        // The absolute difference between the two angles, subtracted from 360 to get the correct angle
        int degrees =  abs(AngleHours, AngleMinutes);
        if(minutes >= 30){
            degrees = abs(degrees,360);
        }
        return degrees + " degrees"; // Returns the angle as a string
    }

    // Private method to test the CountAngle method and compare it to the expected result
    private void TestAngle(String expected_result){
        System.out.println("Testing with Given -> " + "hours = " + this.hours + " minutes = " + this.minutes);
        System.out.println("Result expected = " + expected_result );
        String result = this.CountAngle();
        System.out.println("Test Result = " + result );
        // Checks if the calculated result matches the expected result
        if(result.equals(expected_result)){
            System.out.println("Testing Passed!");
        }else{
            System.out.println("Testing Failed!");
        }
    }

    // Main method to run test cases
    public static void main(String[] args) {
        try{
        // Test case 1: 9:00, expected result is 270 degrees
        System.out.println("\n === SCENARIO TESTING 1 ===");
        Q12Time Time1 = new Q12Time("09:00");
        Time1.TestAngle("270 degrees");
        
        // Test case 2: 3:00, expected result is 90 degrees
        System.out.println("\n === SCENARIO TESTING 2 ===");
        Q12Time Time2 = new Q12Time("03:00");
        Time2.TestAngle("90 degrees");
        
        // Test case 3: 18:00 (6:00 PM), expected result is 180 degrees
        System.out.println("\n === SCENARIO TESTING 3 ===");
        Q12Time Time3 = new Q12Time("18:00");
        Time3.TestAngle("180 degrees");

        // Test case 4: 1:00, expected result is 30 degrees
        System.out.println("\n === SCENARIO TESTING 4 ===");
        Q12Time Time4 = new Q12Time("1:00");
        Time4.TestAngle("30 degrees");

        // Test case 5: 2:30, expected result is 255 degrees
        System.out.println("\n === SCENARIO TESTING 5 ===");
        Q12Time Time5 = new Q12Time("2:30");
        Time5.TestAngle("255 degrees");

        // Test case 6: 4:41, expected result is 254 degrees
        System.out.println("\n === SCENARIO TESTING 6 ===");
        Q12Time Time6 = new Q12Time("4:41");
        Time6.TestAngle("254 degrees");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
