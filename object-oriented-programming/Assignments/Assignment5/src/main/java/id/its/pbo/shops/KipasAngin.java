package id.its.pbo.shops;

public class KipasAngin extends Barang implements Electrifiable {
    public KipasAngin(String c_merk){
        super(c_merk);
    }
    public String powerOn(){
        return "Kipas Angin dinyalakan";
    }

    public String powerOff(){
        return "Kipas Angin dimatikan";
    }
}
