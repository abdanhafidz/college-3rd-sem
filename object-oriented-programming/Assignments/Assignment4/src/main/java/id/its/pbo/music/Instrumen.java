package id.its.pbo.music;

public abstract class Instrumen {
    private String nama;
    public Instrumen(String c_nama){
        this.nama = c_nama;
    }
    public abstract String suara();
    

}
