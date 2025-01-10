package id.its.pbo;

import java.util.Arrays;

public class Control {
    public double negativeHandler(double p){
        if(p < 0){
            System.out.println("This value must non-negative number, we will handled it with 0 value settlement ");
            return 0;
        }else{
            return p;
        }
    }
    public int validateYear(int year){
        if(year > 0){
            return year;
        }else{
            System.out.println("Year value must be > 0");
            return 0;
        }
    }

    public int validateMonth(int month){
        if(month >= 1 && month <=12){
            return month;
        }else{
            System.out.println("Month value must be in range 1 -- 12!");
            return 1;
        }
    }
    public int validateDay(int year, int month, int day){
        Integer[] days31Months =  {1,3,5,7,8,10,12};
        Integer[] days30Months =  {4,5,6,9,11};
        if(day > 0){
            if(month == 2 & year % 4 == 0 ){
                if(day <= 29){
                    return day;
                }else{
                    System.out.println("February in Cabisate must have <= 29 days");
                    return 1;
                }
            }else if(month == 2 && year % 4 == 1){
                if(day <= 28){
                    return day;
                }else{
                    System.out.println("February in Cabisate must have <= 28 days");
                    return 1;
                }
            }else if(Arrays.asList(days31Months).contains(month)){
                if(day <= 31){
                    return day;
                }else{
                    System.out.println("This month have maximum 31 days");
                    return 1;
                }
            }else if(Arrays.asList(days30Months).contains(month)){
                if(day <= 30){
                    return day;
                }else{
                    System.out.println("This month have maximum 30 days");
                    return 1;
                }
            }
        }else{
            System.out.println("day must be > 0");
            return 1;
        }
        return day;
    }
}
