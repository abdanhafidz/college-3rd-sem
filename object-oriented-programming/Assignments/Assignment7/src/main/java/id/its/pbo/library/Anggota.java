package id.its.pbo.library;

public class Anggota {
    private String nama, alamat = "Alamat belum diisi", nomorAnggota;
    public Anggota(String c_nama, String c_nomorAnggota){
        this.nama = c_nama;
        this.nomorAnggota = c_nomorAnggota;
    }
    public Anggota(String c_nama, String c_alamat, String c_nomorAnggota){
        this.nama = c_nama;
        this.alamat = c_alamat;
        this.nomorAnggota = c_nomorAnggota;
    }

    public String getInfoAnggota(){
        return this.nama +", "+this.alamat+", "+this.nomorAnggota;
    }
}
