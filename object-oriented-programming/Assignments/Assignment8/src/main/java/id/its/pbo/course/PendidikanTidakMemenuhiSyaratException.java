package id.its.pbo.course;

public class PendidikanTidakMemenuhiSyaratException extends Exception {
    public PendidikanTidakMemenuhiSyaratException(){
        super("Maaf, tingkat pendidikan Anda tidak memenuhi syarat untuk mengikuti kursus ini.");
    }
}
