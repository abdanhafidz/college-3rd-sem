package id.its.pbo.course;

public class UsiaTidakMemenuhiSyaratException extends Exception {
    public UsiaTidakMemenuhiSyaratException(){
        super("Maaf, usia Anda tidak memenuhi syarat untuk mengikuti kursus ini.");
    }
}
