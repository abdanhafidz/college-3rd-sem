package id.its.pbo.shops;

public class MobilListrik extends Barang implements Electrifiable {
    public MobilListrik(String c_merk){
        super(c_merk);
    }
    public String powerOn(){
        return "Mobil Listrik siap berjalan";
    }

    public String powerOff(){
        return "Mobil Listrik berhenti";
    }
}
