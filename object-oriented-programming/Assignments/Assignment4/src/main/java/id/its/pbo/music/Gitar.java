package id.its.pbo.music;

public class Gitar extends Instrumen {
    public Gitar(String c_nama){
        super(c_nama);
    }
    @Override
    public String suara(){
        return "tring tring";
    }
    
}
