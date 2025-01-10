package id.its.pbo.zoo;

public class Singa extends Hewan implements BisaBersuara{
    public Singa(String c_nama){
        super(c_nama);
    }
    public String suara(){
        return "Roar";
    }
}
