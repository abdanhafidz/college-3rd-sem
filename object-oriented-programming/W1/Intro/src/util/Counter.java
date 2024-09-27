package util;
public class Counter{
    public int Count(int x){
        int result = 0;
        if(x > 0 && x <= 255){
            for (int i = 1; i <= x ; i++){
                result += i;
            }
            System.out.println("");
        }else{
            throw new RuntimeException("x should be between 1 and 255 (inclusive)");
        }
        return result;
    }
}