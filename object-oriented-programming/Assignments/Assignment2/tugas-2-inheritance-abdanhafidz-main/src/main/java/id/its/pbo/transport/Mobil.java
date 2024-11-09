package id.its.pbo.transport;
import id.its.pbo.vehicle.Kendaraan;
public class Mobil extends Kendaraan{
    private String jenis;
    public Mobil(String c_merk, int c_tahunProduksi, String c_jenis){
        super(c_merk, c_tahunProduksi);
        this.jenis = c_jenis;
    }

    public String infoMobil(){
        return this.infoKendaraan() + ", Jenis: " + this.jenis;
    }
    public void setJenis(String c_jenis){
        if(!c_jenis.equals("")){
            this.jenis = c_jenis;
        }
    }
    public String getJenis(){
        return this.jenis;
    }

}
