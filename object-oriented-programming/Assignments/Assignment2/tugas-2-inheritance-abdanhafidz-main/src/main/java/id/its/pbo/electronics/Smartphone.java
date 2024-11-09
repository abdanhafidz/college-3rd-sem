package id.its.pbo.electronics;
import id.its.pbo.gadget.Gadget;
public class Smartphone extends Gadget {
    private String sistemOperasi;
    public Smartphone(String c_brand, int c_tahunRilis, String c_sistemOperasi){
        super(c_brand, c_tahunRilis);
        this.sistemOperasi = c_sistemOperasi;
    }
    public String getSistemOperasi(){
        return this.sistemOperasi;
    }

    public void setSistemOperasi(String c_sistemOperasi){
        if(!c_sistemOperasi.equals("")){
            this.sistemOperasi = c_sistemOperasi;
        }
    }
    public String infoSmartphone(){
        return this.infoGadget() + ", Sistem Operasi: "+this.sistemOperasi;
    }
}
