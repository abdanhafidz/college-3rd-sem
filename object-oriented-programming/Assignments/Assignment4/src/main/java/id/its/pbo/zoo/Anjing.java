package id.its.pbo.zoo;

public class Anjing extends Hewan {
    
    public Anjing(String c_nama){
        super(c_nama);
    }
    @Override
    public String buatSuara(){
        return "Guk";
    }
}
