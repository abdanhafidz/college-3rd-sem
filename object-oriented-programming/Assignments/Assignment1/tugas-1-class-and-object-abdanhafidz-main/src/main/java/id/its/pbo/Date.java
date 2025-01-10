package id.its.pbo;

public class Date {
    private int year;
    private int month;
    private int day;
    private Control controller = new Control();
    public Date(int c_month, int c_day, int c_year){
        this.year = controller.validateYear(c_year);
        this.month = controller.validateMonth(c_month);
        this.day = controller.validateDay(c_year,c_month,c_day);
    }

    public int getYear(){
        return this.year;
    }

    public int getMonth(){
        return this.month;
    }

    public int getDay(){
        return this.day;
    }

    public void setYear(int c_year){
        this.year = controller.validateYear(c_year);
    }

    public void setMonth(int c_month){
        this.year = controller.validateMonth(c_month);
    }

    public void setDay(int c_day){
        this.year = controller.validateDay(this.year,this.month,c_day);
    }

    public String displayDate(){
        return this.month + "/" + this.day + "/" + this.year;
    }

}
