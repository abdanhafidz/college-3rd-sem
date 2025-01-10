package id.its.pbo.registration;

public class Mahasiswa {
    private static int counter = 0;
    private int nomorPendaftaran;
    private String nama;
    public Mahasiswa(String c_nama){
        this.nama = c_nama;
        this.nomorPendaftaran = counter + 1;
        counter ++;
    }
    public int getNomorPendaftaran(){
        return nomorPendaftaran;
    }
    public static int getTotalRegistrant(){
        return counter;
    }

    public static void resetRegistrantCounter(){
        counter = 0;
    }
}
