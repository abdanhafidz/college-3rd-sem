package id.its.pbo.zoo;

public abstract class Hewan {
    private String nama;
    public Hewan(String c_nama){
        this.nama = c_nama;
    }
    public String getNama(){
        return this.nama;
    }
}
