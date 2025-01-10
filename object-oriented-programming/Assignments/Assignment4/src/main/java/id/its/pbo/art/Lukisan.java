package id.its.pbo.art;

public class Lukisan extends KaryaSeni {
    public Lukisan(String c_judul){
        super(c_judul);
    }
    @Override
    public String deskripsi(){
        return "Sebuah gambar yang dilukis di atas kanvas";
    }
    @Override
    public String tampilkan(){
        return "Digantung di dinding";
    }

}
