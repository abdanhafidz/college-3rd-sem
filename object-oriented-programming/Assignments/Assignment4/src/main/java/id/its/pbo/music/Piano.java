package id.its.pbo.music;

public class Piano extends Instrumen {
    public Piano(String c_nama){
        super(c_nama);
    }
    @Override
    public String suara(){
        return "tink tink";
    }
}
