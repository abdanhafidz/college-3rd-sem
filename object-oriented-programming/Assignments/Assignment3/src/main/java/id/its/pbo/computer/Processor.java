package id.its.pbo.computer;

public class Processor {
    private String brand;
    private double kecepatan;

    public Processor(String c_brand, double c_kecepatan){
        this.brand = c_brand;
        this.kecepatan = c_kecepatan;
    }

    public void setBrand(String c_brand){
        if(!c_brand.equals("")){
            this.brand = c_brand;
        }
    }

    public void setKecepatan(double c_kecepatan){
        this.kecepatan = c_kecepatan;
    }

    public String getBrand(){
        return this.brand;
    }

    public double getKecepatan(){
        return this.kecepatan;
    }
}
