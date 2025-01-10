package id.its.pbo.gadget;

public class Gadget {
    private String brand;
    private int tahunRilis;
    public Gadget(String c_brand, int c_tahunRilis){
        this.brand = c_brand;
        this.tahunRilis = c_tahunRilis;
    }

    protected String infoGadget(){
        return "Brand: "+this.brand+", Tahun Rilis: "+this.tahunRilis;
    }
}
