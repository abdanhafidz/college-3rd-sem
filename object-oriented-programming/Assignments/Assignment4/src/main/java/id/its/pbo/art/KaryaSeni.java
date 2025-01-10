package id.its.pbo.art;

public abstract class KaryaSeni {
    private String judul;
    public KaryaSeni(String c_judul){
        this.judul = c_judul;
    }
    public abstract String deskripsi();
    public abstract String tampilkan();
}
