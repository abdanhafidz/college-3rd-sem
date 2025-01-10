package id.its.pbo.perusahaan;

public class Direktur extends Manager{
    private double gaji;
    public Direktur(String c_name, String c_id, String c_departemen, double c_gaji){
        super(c_name, c_id, c_departemen);
        this.gaji = c_gaji;
    }

    public double getGaji(){
        return this.gaji;
    }
}
