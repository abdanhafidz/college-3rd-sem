package id.its.pbo;

public class EmployeeProgram {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Abdan","Hafidz",1000000);
        Employee employee2 = new Employee("Dipo","Negoro",0.1);
        employee1.raiseSalary(5);
        System.out.println("yearly Salary Employee 1: "+employee1.getYearlySalary());
        System.out.println("yearly Salary Employee 2: "+employee2.getYearlySalary());
    }
}
