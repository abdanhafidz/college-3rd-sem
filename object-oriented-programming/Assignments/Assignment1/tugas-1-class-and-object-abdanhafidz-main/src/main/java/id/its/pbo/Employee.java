package id.its.pbo;

public class Employee {
    private String firstName;
    private String lastName;
    private double monthlySalary;
    private Control controller = new Control();
    public Employee(String c_firstName, String c_lastName, double c_monthlySalary){
        this.firstName = c_firstName;
        this.lastName = c_lastName;
        this.monthlySalary = controller.negativeHandler(c_monthlySalary);
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public double getMonthlySalary(){
        return this.monthlySalary;
    }

    public double getYearlySalary(){
        return this.monthlySalary * 12;
    }

    public void raiseSalary(int p){
        if(p >= 0){
            double disc = (double) ((double) p / 100.0) * this.monthlySalary;
            this.monthlySalary += disc;
        }
    }
    
    public void setMonthlySalary(double c_monthlySalary){
        if(c_monthlySalary >= 0){
            this.monthlySalary = c_monthlySalary;
        }
        
    }
}
