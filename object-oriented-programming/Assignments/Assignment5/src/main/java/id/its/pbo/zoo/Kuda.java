package id.its.pbo.zoo;

public class Kuda extends Hewan implements BisaBersuara{
    public Kuda(String c_nama){
        super(c_nama);
    }
    public String suara(){
        return "Neigh";
    }
}
