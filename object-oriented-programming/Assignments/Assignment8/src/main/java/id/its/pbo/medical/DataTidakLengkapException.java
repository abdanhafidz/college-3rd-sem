package id.its.pbo.medical;

public class DataTidakLengkapException extends Exception {
    public DataTidakLengkapException(){
        super("Data pasien tidak lengkap.");
    }
}
