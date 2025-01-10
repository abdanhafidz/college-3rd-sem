package id.its.pbo.shops;

public abstract class Barang {
    private String merk;
    public Barang(String c_merk){
        this.merk = c_merk;
    }

    public String getMerk(){
        return this.merk;
    }
}
