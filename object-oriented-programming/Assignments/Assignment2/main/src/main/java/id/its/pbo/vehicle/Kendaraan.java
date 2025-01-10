package id.its.pbo.vehicle;

public class Kendaraan {
    private String merk;
    private int tahunProduksi;
    public Kendaraan(String merk, int tahunProduksi){
        this.merk = merk;
        this.tahunProduksi = tahunProduksi;
    }
    protected String infoKendaraan(){
        return "Merk: "+this.merk+", Tahun: "+this.tahunProduksi;
    }
}
