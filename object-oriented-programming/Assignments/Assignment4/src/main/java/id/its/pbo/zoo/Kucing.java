package id.its.pbo.zoo;

public class Kucing extends Hewan {
    public Kucing(String c_nama){
        super(c_nama);
    }

    @Override
    public String buatSuara(){
        return "Meong";
    }
    
}
