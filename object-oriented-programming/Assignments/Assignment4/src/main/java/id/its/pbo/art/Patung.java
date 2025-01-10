package id.its.pbo.art;

public class Patung extends KaryaSeni{

    public Patung(String c_judul){
        super(c_judul);
    }
    @Override
    public String deskripsi(){
        return "Sebuah objek tiga dimensi yang dibentuk";
    }
    @Override
    public String tampilkan(){
        return "Diletakkan di atas meja atau lantai";
    }
}
